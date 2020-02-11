package dev.aubique.conj.specifications;

import dev.aubique.conj.connection.ConnectionImpl;
import dev.aubique.conj.entity.Verb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class InsertSpec implements SqlIterableSpecification {

    private static final String SQL_QUERY = "INSERT INTO %s (%s) VALUES (%s)";
    private final String VERB_TABLE_NAME;
    private final String TENSE_TABLE_NAME;
    private final List<String> TENSE_COLUMNS;
    private final List<String> VERB_COLUMNS;

    private List<String> queries;
    private Iterator<String> iter;

    public InsertSpec(Verb verbObj) {
        this.VERB_TABLE_NAME = ConnectionImpl.VERB_TABLE_NAME;
        this.TENSE_TABLE_NAME = ConnectionImpl.TENSE_TABLE_NAME;
        this.TENSE_COLUMNS = ConnectionImpl.TENSE_TABLE_COLUMNS;
        this.VERB_COLUMNS = ConnectionImpl.VERB_TABLE_COLUMNS;
        this.queries = new ArrayList<>();
        // Fill out the query-list for iterator to attach with
        this.constructQueries(verbObj);
        this.iter = queries.iterator();
    }

    private static String generateSqlQueryFromList(String table, List<String> columns, List<String> values) {
        return String.format(
                SQL_QUERY,
                table,
                String.join(",", columns),
                values.stream()
                        .map(value -> String.format("\'%s\'", value.replace("'", "''")))
                        .collect(Collectors.joining(","))
        );
    }

    private void constructQueries(Verb verbObj) {
        //TODO: create getTenseFields method in entity-class
        List<String> tenseFields = new ArrayList<>();
        tenseFields.add(verbObj.getVerbName());
        tenseFields.add(verbObj.getPresentField());
        tenseFields.add(verbObj.getPresentPerfectField());
        tenseFields.add(verbObj.getImperfectField());
        tenseFields.add(verbObj.getFutureField());

        this.queries.add(generateSqlQueryFromList(VERB_TABLE_NAME, VERB_COLUMNS, tenseFields));
        // Skip the first element
        for (int i = 1; i < tenseFields.size(); i++) {
            this.queries.add(generateSqlQueryFromList(TENSE_TABLE_NAME, TENSE_COLUMNS,
                    verbObj.getTenseListByTenseId(tenseFields.get(i))));
        }
    }

    @Override
    public String toSqlQuery() {
        final String query = iter.next();

        System.out.println(query);
        return query;
    }

    public boolean hasNextQuery() {
        return iter.hasNext();
    }
}
