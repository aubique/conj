package dev.aubique.conj.services;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import dev.aubique.conj.entity.Verb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ParserService {

    private static final String PRESENT_TENSE_DESC = "Indicatif présent";
    private static final String PRESENT_PERFECT_DESC = "Indicatif passé composé";
    private static final String IMPERFECT_TENSE_DESC = "Indicatif imparfait";
    private static final String FUTURE_TENSE_DESC = "Indicatif futur";

    private final String BASE_URL = "https://fr.bab.la/conjugaison/francais/";
    private final String xpathInfinitive = "//div[@class=\'quick-result-entry\'][1]/div[@class=\'quick-result-overview\']/ul/li/text()";
    private final String xpathTense = "//h3[@class=\'conj-tense-block-header\'][text()=\'%s\']/../div";
    private HtmlPage page = null;
    private String targetVerb = null;
    private String infinitive;
    private WebClient client = new WebClient();
    private Map<String, String> selectNames = new TreeMap<>();

    public ParserService(String verbToFind) {
        this.targetVerb = verbToFind;
        this.client.getOptions().setJavaScriptEnabled(false);
        this.client.getOptions().setCssEnabled(false);
        this.client.getOptions().setUseInsecureSSL(true);
        selectNames.put(PRESENT_TENSE_DESC, Verb.presentSuffix);
        selectNames.put(PRESENT_PERFECT_DESC, Verb.presentPerfectSuffix);
        selectNames.put(IMPERFECT_TENSE_DESC, Verb.imperfectSuffix);
        selectNames.put(FUTURE_TENSE_DESC, Verb.futureSuffix);
    }

    public Map<String, List<String>> parse() {
        Map<String, List<String>> dict = new TreeMap<>();

        if (this.targetVerb.isEmpty()) {
            this.targetVerb = "pouvoir";
        }
        try {
            this.page = this.client.getPage(this.BASE_URL + this.targetVerb);
            this.infinitive = ((DomText) page.getFirstByXPath(this.xpathInfinitive)).getTextContent();
            selectNames.entrySet().stream()
                    .forEach(e -> dict.put(this.infinitive + e.getValue(), getSixForms(e.getKey())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dict;
    }

    private List<String> getSixForms(String key) {
        List<String> tenseContent = new ArrayList<>();
        System.out.println();
        List<HtmlDivision> divs = this.page.getByXPath(String.format(this.xpathTense, key));
        for (HtmlDivision div : divs) {
            DomText conjPerson = div.getFirstByXPath("div[@class=\'conj-person\']/text()");
            DomText conjResult = div.getFirstByXPath("div[@class=\'conj-result\']/text()");
            StringBuilder conjItem = new StringBuilder();
            conjItem.append(conjPerson.getTextContent());
            conjItem.append(" ");
            conjItem.append(conjResult.getTextContent());
//            System.out.println(conjItem.toString());
            tenseContent.add(conjItem.toString());
        }

        return tenseContent;
    }
}
