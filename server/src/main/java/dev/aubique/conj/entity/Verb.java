package dev.aubique.conj.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Verb implements Serializable {

    private static final String presentSuffix = "_pr";
    private static final String presentPerfectSuffix = "_pp";
    private static final String imperfectSuffix = "_im";
    private static final String futureSuffix = "_fu";

    private String verbName;
    private String presentField;
    private String presentPerfectField;
    private String imperfectField;
    private String futureField;

    private List<String> presentTenseList;
    private List<String> presentPerfectTenseList;
    private List<String> imperfectTenseList;
    private List<String> futureTenseList;


    public Verb(String verbName) {
        this.verbName = verbName;
        this.presentField = verbName + presentSuffix;
        this.presentPerfectField = verbName + presentPerfectSuffix;
        this.imperfectField = verbName + imperfectSuffix;
        this.futureField = verbName + futureSuffix;
    }

    public Verb(
            String verbName,
            List<String> presentTenseList,
            List<String> presentPerfectTenseList,
            List<String> imperfectTenseList,
            List<String> futureTenseList
    ) {
        this(verbName);
        this.presentTenseList = presentTenseList;
        this.presentPerfectTenseList = presentPerfectTenseList;
        this.imperfectTenseList = imperfectTenseList;
        this.futureTenseList = futureTenseList;
    }

    public Verb(String verbName, Map<String, List<String>> tenseDictionary) {
        this(verbName);
        this.presentTenseList = tenseDictionary.get(this.presentField);
        this.presentPerfectTenseList = tenseDictionary.get(this.presentPerfectField);
        this.imperfectTenseList = tenseDictionary.get(this.imperfectField);
        this.futureTenseList = tenseDictionary.get(this.futureField);
    }

    public Map<String, Map<String, List<String>>> asDictionary() {
        Map<String, Map<String, List<String>>> dict = new TreeMap<>();
        Map<String, List<String>> tenses = new TreeMap<>();

        tenses.put(presentField, presentTenseList);
        tenses.put(presentPerfectField, presentPerfectTenseList);
        tenses.put(imperfectField, imperfectTenseList);
        tenses.put(futureField, futureTenseList);

        dict.put(verbName, tenses);
        return dict;
    }

    public List<String> getTenseListByTenseId(String tenseId) {
        List<String> tenseList = new ArrayList<>();
        String verbId = tenseId.substring(0, tenseId.length() - 3);

        tenseList.add(verbId);
        tenseList.add(tenseId);
        tenseList.addAll(this.asDictionary().get(verbId).get(tenseId));

        return tenseList;
    }

    public String getVerbName() {
        return verbName;
    }

    public String getPresentField() {
        return presentField;
    }

    public String getPresentPerfectField() {
        return presentPerfectField;
    }

    public String getImperfectField() {
        return imperfectField;
    }

    public String getFutureField() {
        return futureField;
    }

    public List<String> getPresentTenseList() {
        return presentTenseList;
    }

    public List<String> getPresentPerfectTenseList() {
        return presentPerfectTenseList;
    }

    public List<String> getImperfectTenseList() {
        return imperfectTenseList;
    }

    public List<String> getFutureTenseList() {
        return futureTenseList;
    }
}
