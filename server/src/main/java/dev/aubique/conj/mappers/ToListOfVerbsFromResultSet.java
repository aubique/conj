package dev.aubique.conj.mappers;

import dev.aubique.conj.entity.Verb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToListOfVerbsFromResultSet implements Mapper<ResultSet, List<Verb>> {
    final int NUMBER_OF_TENSES = 4;

    @Override
    public List<Verb> map(ResultSet rs) throws SQLException {
        ArrayList<Verb> mappedVerbs = new ArrayList<>();
        List<List<String>> tenses = new ArrayList<>();
        List<String> tense = new ArrayList<>();
        int count = 0;

        for (int tenseSeq = 1; rs.next(); tenseSeq++) {
            final String infinitive = rs.getString("verb_name");
//            System.out.println(tenseSeq);
//            System.out.println(infinitive);
//            System.out.println(count);

            for (int pos = 3; pos < 9; pos++) {
//                System.out.println(rs.getString(pos));
                tense.add(rs.getString(pos));
            }
            tenses.add(tense);
            tense = new ArrayList<>();

            if (tenseSeq % NUMBER_OF_TENSES == 0) {
                mappedVerbs.add(new Verb(
                        infinitive,
                        tenses.get(0),
                        tenses.get(1),
                        tenses.get(2),
                        tenses.get(3)
                ));
                tenses = new ArrayList<>();
            }
        }

        return mappedVerbs;
    }
}
