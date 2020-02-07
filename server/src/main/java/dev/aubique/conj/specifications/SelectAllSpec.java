package dev.aubique.conj.specifications;

public class SelectAllSpec implements SqlSpecification {

    private static final String SQL_QUERY = "SELECT tense.* FROM verb RIGHT JOIN tense ON verb.infinitive = tense.verb_name";

    @Override
    public String toSqlQuery() {
        final String query = SQL_QUERY;

        System.out.println(query);
        return query;
    }
}
