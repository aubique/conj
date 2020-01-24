package dev.aubique.demo.models;

public class VerbDo {

    private String infinitive;
    private String presentName = "Present Simple Tense";
    private String[] presentTense;
    private String presentPerfectName = "Present Perfect Tense";
    private String[] presentPerfectTense;

    public VerbDo(String infinitive, String[] presentTense, String[] presentPerfectTense) {
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

    public String[] getPresentTense() {
        return presentTense;
    }

    public String getPresentPerfectName() {
        return presentPerfectName;
    }

    public String[] getPresentPerfectTense() {
        return presentPerfectTense;
    }
}
