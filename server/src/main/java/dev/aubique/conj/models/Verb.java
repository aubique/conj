package dev.aubique.conj.models;

import java.util.List;

public class Verb {

    private String infinitive;
    private String presentName = "Present Simple Tense";
    private List<String> presentTense;
    private String presentPerfectName = "Present Perfect Tense";
    private List<String> presentPerfectTense;

    public Verb(String infinitive, List<String> presentTense, List<String> presentPerfectTense) {
        this.infinitive = infinitive;
        this.presentTense = presentTense;
        this.presentPerfectTense = presentPerfectTense;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public String getPresentName() {
        return presentName;
    }

    public List<String> getPresentTense() {
        return presentTense;
    }

    public String getPresentPerfectName() {
        return presentPerfectName;
    }

    public List<String> getPresentPerfectTense() {
        return presentPerfectTense;
    }
}
