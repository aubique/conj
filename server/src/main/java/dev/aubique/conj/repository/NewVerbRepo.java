package dev.aubique.conj.repository;

import dev.aubique.conj.connection.ConnectionImpl;
import dev.aubique.conj.entity.Verb;
import dev.aubique.conj.mappers.Mapper;
import dev.aubique.conj.mappers.ToListOfVerbsFromResultSet;
import dev.aubique.conj.specifications.SqlSpecification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class VerbRepository implements CanonRepository<Verb> {

    private final Mapper<ResultSet, List<Verb>> toListOfVerbs;
    private List<Verb> repo;

    public VerbRepository() {
        toListOfVerbs = new ToListOfVerbsFromResultSet();
    }

    @Override
    public void add(Verb entity) {
    }

    public void add(SqlSpecification specification) {
        try (Connection conn = ConnectionImpl.getConnection();
             Statement stmt = conn.createStatement();
        ) {
            stmt.execute(specification.toSqlQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                Connection conn = ConnectionImpl.getConnection();
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
