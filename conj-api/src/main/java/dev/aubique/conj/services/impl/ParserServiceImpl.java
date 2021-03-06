package dev.aubique.conj.services.impl;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import dev.aubique.conj.model.VerbEntity;
import dev.aubique.conj.services.ParserService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserServiceImpl implements ParserService {

    private final static String BASE_URL = "https://fr.bab.la/conjugaison/francais/";
    private final static String XPATH_INFINITIVE = "//div[@class='quick-result-entry'][1]/div[@class='quick-result-overview']/ul/li/text()";
    private final static String XPATH_TENSE = "//h3[@class='conj-tense-block-header'][text()='%s']/../div";

    private WebClient client = new WebClient();

    public ParserServiceImpl() {
        setOptions();
    }

    private static List<String> parseSixForms(String tenseName, HtmlPage page) {
        List<String> tenseContent = new ArrayList<>();
        List<HtmlDivision> divs = page.getByXPath(String.format(XPATH_TENSE, tenseName));
        tenseContent.add(tenseName);
        for (HtmlDivision div : divs) {
            DomText conjPerson = div.getFirstByXPath("div[@class='conj-person']/text()");
            DomText conjResult = div.getFirstByXPath("div[@class='conj-result']/text()");
            StringBuilder conjItem = new StringBuilder();
            conjItem.append(conjPerson.getTextContent());
            conjItem.append(" ").append(conjResult.getTextContent());
//            System.out.println(conjItem.toString());
            tenseContent.add(conjItem.toString());
        }

        return tenseContent;
    }

    private static VerbEntity parseIndicative(VerbEntity verb, HtmlPage page) {
        final String presentIndicative = "Indicatif présent";
        final String presentPerfectIndicative = "Indicatif passé composé";
        final String presentImperfectIndicative = "Indicatif imparfait";
        final String pluperfectIndicative = "Indicatif plus-que-parfait";
        final String simplePastIndicative = "Indicatif passé simple";
        final String pastPerfectIndicative = "Indicatif passé antérieur";
        final String futureIndicative = "Indicatif futur";
        final String pastFutureIndicative = "Indicatif futur antérieur";

        verb.setIndPresentList(parseSixForms(presentIndicative, page));
        verb.setIndPresentPerfectList(parseSixForms(presentPerfectIndicative, page));
        verb.setIndImperfectList(parseSixForms(presentImperfectIndicative, page));
        verb.setIndPluperfectList(parseSixForms(pluperfectIndicative, page));
        verb.setIndSimplePastList(parseSixForms(simplePastIndicative, page));
        verb.setIndPastPerfectList(parseSixForms(pastPerfectIndicative, page));
        verb.setIndFutureList(parseSixForms(futureIndicative, page));
        verb.setIndPastFutureList(parseSixForms(pastFutureIndicative, page));

        return verb;
    }

    private static VerbEntity parseSubjunctive(VerbEntity verb, HtmlPage page) {
        final String presentSubjunctive = "Subjonctif présent";
        final String pastSubjunctive = "Subjonctif passé";
        final String imperfectSubjunctive = "Subjonctif imparfait";
        final String pluperfectSubjunctive = "Subjonctif plus-que-parfait";

        verb.setSubPresentList(parseSixForms(presentSubjunctive, page));
        verb.setSubPastList(parseSixForms(pastSubjunctive, page));
        verb.setSubImperfectList(parseSixForms(imperfectSubjunctive, page));
        verb.setSubPluperfectList(parseSixForms(pluperfectSubjunctive, page));

        return verb;
    }

    private static VerbEntity parseConditionalImperative(VerbEntity verb, HtmlPage page) {
        final String presentConditional = "Conditionnel présent";
        final String pastConditional = "Conditionnel passé";
        final String presentImperative = "Impératif";

        verb.setConPresentList(parseSixForms(presentConditional, page));
        verb.setConPastList(parseSixForms(pastConditional, page));
        verb.setImpPresentList(parseSixForms(presentImperative, page));

        return verb;
    }

    private void setOptions() {
        this.client.getOptions().setJavaScriptEnabled(false);
        this.client.getOptions().setCssEnabled(false);
        this.client.getOptions().setUseInsecureSSL(true);
    }

    @Override
    public VerbEntity parseVerb(String verbName) {
        return doParsing(verbName);
    }

    private VerbEntity doParsing(String verbName) {
        final VerbEntity verbObj = new VerbEntity();
        try {
            final HtmlPage page = client.getPage(this.BASE_URL + verbName);
            final DomText infinitiveDom = page.getFirstByXPath(XPATH_INFINITIVE);

//            if (infinitiveDom == null) {
//                verbObj.setName(verbName);
//                verbObj.setName("");
//                return null;
//            } else {
                verbObj.setName(infinitiveDom.getTextContent());
//            }

            parseIndicative(verbObj, page);
            parseSubjunctive(verbObj, page);
            parseConditionalImperative(verbObj, page);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } catch (NullPointerException ex) {
            return null;
        }

        return verbObj;
    }
}
