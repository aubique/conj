package dev.aubique.conj.specifications;

public class SelectByNameSpec implements SqlSpecification {

    private static final String SQL_QUERY = "SELECT tense.* FROM verb RIGHT JOIN tense ON verb.infinitive = tense.verb_name WHERE verb.infinitive = \'%s\'";
    private final String infinitive;

    public SelectByNameSpec(String infinitive) {
        this.infinitive = infinitive;
    }

    @Override
    public String toSqlQuery() {
        final String query = String.format(SQL_QUERY, infinitive);

        System.out.println(query);
        return query;
    }
}
