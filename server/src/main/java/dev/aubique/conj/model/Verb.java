package dev.aubique.conj.model;

import java.util.List;

public class Verb {

    private String infinitive;
    private List<String> presentTense;
    private List<String> presentPerfectTense;
    private List<String> imperfectTense;
    private List<String> futureTense;

    public Verb(
            String infinitive,
            List<String> presentTense,
            List<String> presentPerfectTense,
            List<String> imperfectTense,
            List<String> futureTense
    ) {
        this.infinitive = infinitive;
        this.presentTense = presentTense;
        this.presentPerfectTense = presentPerfectTense;
        this.imperfectTense = imperfectTense;
        this.futureTense = futureTense;
    }
}
