package dev.aubique.conj.specifications;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

@Deprecated
public class InsertSpec implements SqlSpecification {

    private static final String[] TENSE_COLS = {
            "verb_name",
            "tense_name",
            "first_person_singular",
            "second_person_singular",
            "third_person_singular",
            "first_person_plural",
            "second_person_plural",
            "third_person_plural"
    };

    private static final String[] VERB_COLS = {
            "infinitive",
            "present_tense",
            "present_perfect_tense",
            "imperfect_tense",
            "future_tense"
    };

    private static final List<String> TENSE_TABLE_COLUMNS = new ArrayList<>(Arrays.asList(TENSE_COLS));
    private static final List<String> VERB_TABLE_COLUMNS = new ArrayList<>(Arrays.asList(VERB_COLS));

    private List<String> queries;
    private Iterator<String> iter;
    private Map<String, Map<String, List<String>>> dict;

    public InsertSpec(Map<String, Map<String, List<String>>> objectAsDictionary) {
        this.queries = new ArrayList<>();
        this.dict = objectAsDictionary;

        // Some factory code to iterate over dictionary
        queries.add(generateInsertQuery("verb", zipToMap(VERB_TABLE_COLUMNS, buildVerbTable())));
        for (List<String> list : buildTenseTable()) {
            queries.add(generateInsertQuery("tense", zipToMap(TENSE_TABLE_COLUMNS, list)));
        }

        this.iter = queries.iterator();
    }

    private static <K, V> Map<K, V> zipToMap(List<K> columns, List<V> values) {
        Map<K, V> map = new HashMap<>();
        for (Integer i = 0; i < columns.size(); i++) {
            if (map.put(columns.get(i), values.get(i)) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }
        return map;
    }

    private static <K, V> String generateInsertQuery(String table, Map<K, V> dictionary) {
        StringBuilder columnsLine = new StringBuilder(String.format("INSERT INTO %s (", table));
        StringBuilder valuesLine = new StringBuilder("VALUES (");

        for (Map.Entry<K, V> entry : dictionary.entrySet()) {
            columnsLine.append(String.format("%s,", entry.getKey()));
            valuesLine.append(String.format("\'%s\',", entry.getValue()));
        }
        columnsLine = new StringBuilder(columnsLine.substring(0, columnsLine.length() - 1) + ')');
        valuesLine = new StringBuilder(valuesLine.substring(0, valuesLine.length() - 1) + ')');
        return columnsLine.toString() + valuesLine.toString();
    }

    private List<String> buildVerbTable() {
//        List<List<String>> verbTableValues = new ArrayList<>();
        List<String> keys = new ArrayList<>();

        for (Map.Entry<String, Map<String, List<String>>> verbEntry : dict.entrySet()) {

            keys.add(verbEntry.getKey());
            for (Map.Entry<String, List<String>> tenseEntry : verbEntry.getValue().entrySet()) {
                keys.add(tenseEntry.getKey());
            }
//            verbTableValues.add(keys);

            try {
                // Debug output
                System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(keys));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
        return keys;
    }

    private List<List<String>> buildTenseTable() {
        List<List<String>> tenseTableValues = new ArrayList<>();

        for (Map.Entry<String, Map<String, List<String>>> verbEntry : dict.entrySet()) {
            List<String> values = new ArrayList<>();

            values.add(verbEntry.getKey());
            for (Map.Entry<String, List<String>> tenseEntry : verbEntry.getValue().entrySet()) {
                values.add(tenseEntry.getKey());

                for (String verbForm : tenseEntry.getValue()) {
                    values.add(verbForm);
                }
            }
            tenseTableValues.add(values);

            try {
                // Debug output
                System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(values));
                System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(tenseTableValues));
            } catch (JsonProcessingException e) {
            }

        }
        return tenseTableValues;
    }

    @Override
    public String toSqlQuery() {
        return iter.next();
    }

    public boolean hasNextQuery() {
        return this.iter.hasNext();
    }
}
