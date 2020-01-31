package dev.aubique.conj.entity;

import java.util.List;

public class VerbNew {

    private String verbName;
    private String presentSuffix = "_pr";
    private String presentPerfectSuffix = "_pp";
    private String imperfectSuffix = "_im";
    private String futureSuffix = "_fu";

    private List<String> presentTenseList;
    private List<String> presentPerfectTenseList;
    private List<String> imperfectTenseList;
    private List<String> futureTenseList;
}
