package dev.aubique.conj.specifications;

public class SelectByNameSpec implements SqlSpecification {

    private String infinitive;

    public SelectByNameSpec(String infinitive) {
        this.infinitive = infinitive;
    }

    @Override
    public String toSqlQuery() {
        String lineOne = "SELECT tense.* FROM verb RIGHT JOIN tense ON verb.infinitive = tense.verb_name";
        String lineTwo = "WHERE verb.infinitive =";
        return String.format("%s %s \'%s\'", lineOne, lineTwo, infinitive);
    }
}
