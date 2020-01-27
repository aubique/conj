package dev.aubique.conj.repositories;

import dev.aubique.conj.models.Verb;
import dev.aubique.conj.specifications.SqlSpecification;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VerbRepository implements CanonRepository<Verb> {

    private static final String URL = "jdbc:postgresql://localhost:5432/conj";
    private static final String PASSWD = "idea";
    private static final int NUMBER_OF_TENSES = 2;
    private List<Verb> repo;

    public VerbRepository() {
    }

    private static List<Verb> toListOfVerbs(ResultSet rs) throws SQLException {
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
                mappedVerbs.add(new Verb(infinitive, tenses.get(0), tenses.get(1)));
                tenses = new ArrayList<>();
            }
        }

        return mappedVerbs;
    }

    @Override
    public void add(Verb entity) {
    }

    @Override
    public void update(Verb entity) {
    }

    @Override
    public void remove(Verb entity) {
    }

    @Override
    public List<Verb> query(SqlSpecification specification) {
        //TODO: Implement SqlSpecification
        List<Verb> repository = null;
        final String query
                = "SELECT tense.* FROM verb RIGHT JOIN tense "
                + "ON verb.infinitive = tense.verb_name";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection conn = DriverManager.getConnection(URL, PASSWD, PASSWD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {
            this.repo = repository = toListOfVerbs(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return repository;
    }
}
