package dev.aubique.conj.mock;

import dev.aubique.conj.model.VerbEntity;

import java.util.Arrays;

public class AllerVerbFactory {

    // Expected values
    public static final String INDICATIVE_GROUP_DTO_EXPECTED = "";
    // INDICATIVE
    public static final String[] PRESENT_INDICATIVE = {"Indicatif présent", "Je vais", "Tu vas", "Il va", "Nous allons", "Vous allez", "Ils vont"};
    public static final String[] PRESENT_PERFECT_INDICATIVE = {"Indicatif passé composé", "Je suis allé", "T'es allé", "Il est allé", "Nous sommes allés", "Vous êtes allés", "Ils sont allés"};
    public static final String[] PRESENT_IMPERFECT_INDICATIVE = {"Indicatif imparfait", "J'allais", "T'allais", "Il allait", "Nous allions", "Vous alliez", "Ils allaient"};
    public static final String[] PLUPERFECT_INDICATIVE = {"Indicatif plus-que-parfait", "J'étais allé", "T'étais allé", "Il était allé", "Nous étions allés", "Vous étiez allés", "Ils étaient allés"};
    public static final String[] SIMPLE_PAST_INDICATIVE = {"Indicatif passé simple", "J'allai", "Tu allas", "Il alla", "Nous allâmes", "Vous allâtes", "Ils allèrent"};
    public static final String[] PAST_PERFECT_INDICATIVE = {"Indicatif passé antérieur", "Je fus allé", "Tu fus allés", "Vous fûtes allés", "Ils furent allés"};
    public static final String[] FUTURE_INDICATIVE = {"Indicatif futur", "J'irai", "Tu iras", "Il ira", "Nous irons", "Vous irez", "Ils iront"};
    public static final String[] PAST_FUTURE_INDICATIVE = {"Indicatif futur antérieur", "Je serai allé", "Tu seras allé", "Il sera allé", "Nous serons allés", "Ils seront allé"};
    // SUBJUNCTIVE
    public static final String[] PRESENT_SUBJUNCTIVE = {"Subjonctif présent", "J'aille", "Tu ailles", "Il aille", "Nous allions", "Vous alliez", "Ils aillent"};
    public static final String[] PAST_SUBJUNCTIVE = {"Subjonctif passé", "Je sois allé", "Il soit allé", "Nous soyons allés", "Vous soyez allés", "Ils soient allés"};
    public static final String[] IMPERFECT_SUBJUNCTIVE = {"Subjonctif imparfait", "J'allasse", "Tu allasses", "Il allât", "Nous allassions", "Vous allassiez", "Ils allassent"};
    public static final String[] PLUPERFECT_SUBJUNCTIVE = {"Subjonctif plus-que-parfait", "Je fusse allé", "Tu fusses allé", "Il fût allé", "Nous fussions allés", "Vous fussiez allés", "Ils fussent allés"};
    // CONDITIONAL, IMPERATIVE
    public static final String[] PRESENT_CONDITIONAL = {"Conditionnel présent", "J'irais", "Tu irais", "Il irait", "Nous irions", "Vous iriez", "Ils iraient"};
    public static final String[] PAST_CONDITIONAL = {"Conditionnel passé", "Je serais allé", "Tu serais allé", "Il serait allé", "Nous serions allés", "Vous seriez allés", "Ils seraient allés"};
    public static final String[] PRESENT_IMPERATIVE = {"Impératif", "Tu va", "Nous allons", "Vous allez"};
    private final VerbEntity entity;

    public AllerVerbFactory() {
        entity = new VerbEntity();
        // Set INDICATIVE
        entity.setIndPresentList(Arrays.asList(PRESENT_INDICATIVE));
        entity.setIndPresentPerfectList(Arrays.asList(PRESENT_PERFECT_INDICATIVE));
        entity.setIndImperfectList(Arrays.asList(PRESENT_IMPERFECT_INDICATIVE));
        entity.setIndPluperfectList(Arrays.asList(PLUPERFECT_INDICATIVE));
        entity.setIndSimplePastList(Arrays.asList(SIMPLE_PAST_INDICATIVE));
        entity.setIndPastPerfectList(Arrays.asList(PAST_PERFECT_INDICATIVE));
        entity.setIndFutureList(Arrays.asList(FUTURE_INDICATIVE));
        entity.setIndPastFutureList(Arrays.asList(PAST_FUTURE_INDICATIVE));
        // Set SUBJUNCTIVE
        entity.setSubPresentList(Arrays.asList(PRESENT_SUBJUNCTIVE));
        entity.setSubPastList(Arrays.asList(PAST_SUBJUNCTIVE));
        entity.setSubImperfectList(Arrays.asList(IMPERFECT_SUBJUNCTIVE));
        entity.setSubPluperfectList(Arrays.asList(PLUPERFECT_SUBJUNCTIVE));
        // Set CONDITIONAL and IMPERATIVE
        entity.setConPresentList(Arrays.asList(PRESENT_CONDITIONAL));
        entity.setConPastList(Arrays.asList(PAST_CONDITIONAL));
        entity.setImpPresentList(Arrays.asList(PRESENT_IMPERATIVE));
    }

    public VerbEntity getEntity() {
        return entity;
    }
}
