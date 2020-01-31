package dev.aubique.conj.specifications;

public class SelectAllSpec implements SqlSpecification {

    @Override
    public String toSqlQuery() {
        return "SELECT tense.* FROM verb RIGHT JOIN tense ON verb.infinitive = tense.verb_name";
    }
}
