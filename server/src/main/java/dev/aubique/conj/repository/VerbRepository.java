package dev.aubique.conj.repository;

import dev.aubique.conj.connection.ConnectionImpl;
import dev.aubique.conj.entity.Verb;
import dev.aubique.conj.mappers.ToDictFromResultSet;
import dev.aubique.conj.specifications.SqlIterableSpecification;
import dev.aubique.conj.specifications.SqlSpecification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerbRepository {

    @Deprecated
    private Map<String, Verb> repository;

    public Map<String, Verb> query(SqlSpecification specification) {
        final ToDictFromResultSet toDict = new ToDictFromResultSet();
        Map<String, Map<String, List<String>>> primitiveRepo = new TreeMap<>();
        Map<String, Verb> objectRepo = new TreeMap<>();

        try (
                Connection conn = ConnectionImpl.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(specification.toSqlQuery())
        ) {
            objectRepo.putAll(toDict.map(rs));
            this.repository = objectRepo;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objectRepo;
    }

    public void add(SqlSpecification specification) {
        SqlIterableSpecification spec = (SqlIterableSpecification) specification;

        try (
                Connection conn = ConnectionImpl.getConnection();
                Statement stmt = conn.createStatement()
        ) {
            while (spec.hasNextQuery()) {
                System.out.println("repository.add(): " + spec.toSqlQuery());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
