package dev.aubique.conj.repository;

import dev.aubique.conj.mappers.Mapper;
import dev.aubique.conj.mappers.ToListOfVerbsFromResultSet;
import dev.aubique.conj.model.Verb;
import dev.aubique.conj.specifications.SqlSpecification;

import java.sql.*;
import java.util.List;

public class VerbRepository implements CanonRepository<Verb> {

    //TODO: put database-properties away to another standalone class
    private static final String URL = "jdbc:postgresql://localhost:5432/conj";
    private static final String PASSWD = "idea";
    private final Mapper<ResultSet, List<Verb>> toListOfVerbs;
    private List<Verb> repo;

    public VerbRepository() {
        toListOfVerbs = new ToListOfVerbsFromResultSet();
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
        List<Verb> repository = null;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection conn = DriverManager.getConnection(URL, PASSWD, PASSWD);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(specification.toSqlQuery())
        ) {
            this.repo = repository = toListOfVerbs.map(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return repository;
    }

    //TODO: the meaning of use repository-in-memory along with repository-in-database is controversial
    public List<Verb> getRepo() {
        return this.repo;
    }
}
