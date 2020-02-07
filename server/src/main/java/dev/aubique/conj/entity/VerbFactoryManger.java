package dev.aubique.conj.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerbFactoryManger {

    private static String verbName = "manger";
    private Verb dummy;

    private static List<String> getPresentTenseList() {
        String[] presentTense = {
                "je mange",
                "tu mange",
                "il mange",
                "nous mangons",
                "vous mangez",
                "ils mangent"
        };
        return new ArrayList<>(Arrays.asList(presentTense));
    }

    private static List<String> getFutureTenseList() {
        String[] presentTense = {
                "je mangerai",
                "tu mangeras",
                "il mangera",
                "nous mangerons",
                "vous mangerez",
                "ils mangeront"
        };
        return new ArrayList<>(Arrays.asList(presentTense));
    }

    private static List<String> getImperfectTenseList() {
        String[] presentTense = {
                "je mangeais",
                "tu mangeais",
                "il mangeait",
                "nous mangions",
                "vous mangiez",
                "ils mangeaient"
        };
        return new ArrayList<>(Arrays.asList(presentTense));
    }

    private static List<String> getPresentPerfectTenseList() {
        String[] presentTense = {
//                "jai mangé",
                "j'ai mangé",
                "tu as mangé",
                "il as mangé",
                "nous avons mangé",
                "vous avez mangé",
                "ils ont mangé"
        };
        return new ArrayList<>(Arrays.asList(presentTense));
    }

    public Verb construct() {
        this.dummy = new Verb(
                verbName,
                getPresentTenseList(),
                getPresentPerfectTenseList(),
                getImperfectTenseList(),
                getFutureTenseList()
        );

        return dummy;
    }
}
