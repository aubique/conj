package dev.aubique.conj.mappers;

import dev.aubique.conj.entity.Verb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ToDictFromResultSet {

    private final static int NUMBER_OF_TENSES = 4;
    private final static String VERB_NAME_FIELD = "verb_name";
    //TODO: switch to getString(FIELD_NAME) while parseSixForms
    public Verb dummy;

    private static boolean resultSetHasNext(ResultSet rs) throws SQLException {
        return !rs.isLast() && ((rs.getRow() != 0) || rs.isBeforeFirst());
    }

    private static boolean isSameVerb(int count) {
        return count < NUMBER_OF_TENSES;
    }

    private static Map<String, List<String>> parseSixForms(ResultSet rs) throws SQLException {
        List<String> sixForms = new ArrayList<>();
        Map<String, List<String>> result = new TreeMap<>();

        for (int position = 3; position < 9; position++) {
            sixForms.add(rs.getString(position));
//            System.out.println(position);
        }
        result.put(rs.getString(2), sixForms);

        return result;
    }

    public Map<String, Map<String, List<String>>> mapToPrimitive(ResultSet rs) throws SQLException {
        String verbName = null;
        Map<String, List<String>> sixFormsCompleted = new TreeMap<>();
        Map<String, Map<String, List<String>>> primitiveMap = new TreeMap<>();

        while (resultSetHasNext(rs)) {
            for (int i = 0; isSameVerb(i); i++) {
                rs.next();
                verbName = rs.getString(VERB_NAME_FIELD);
                sixFormsCompleted.putAll(parseSixForms(rs));
            }
            primitiveMap.put(verbName, sixFormsCompleted);
        }

        return primitiveMap;
    }

    public Map<String, Verb> map(ResultSet rs) throws SQLException {
        Map<String, Verb> objectMap = new TreeMap<>();

        this.mapToPrimitive(rs).entrySet().stream()
                .forEach((entry) -> {
                    objectMap.put(
                            entry.getKey(),
                            new Verb(entry.getKey(), entry.getValue())
                    );
                });

//        // Debug output
//        try {
//            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(objectMap));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        this.dummy = objectMap.get("faire");
        return objectMap;
    }

}
