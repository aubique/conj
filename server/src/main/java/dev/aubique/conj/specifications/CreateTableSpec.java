package dev.aubique.conj.specifications;

import dev.aubique.conj.entity.Verb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateTableSpec implements SqlIterableSpecification {

    private static final String CREATE_VERB = "CREATE TABLE IF NOT EXISTS verb\n" +
            "(created_at TIMESTAMP DEFAULT now(),\n" +
            "infinitive VARCHAR NOT NULL\n" +
            "CONSTRAINT verb_pkey\n" +
            "PRIMARY KEY,\n" +
            "present_tense VARCHAR,\n" +
            "present_perfect_tense VARCHAR,\n" +
            "imperfect_tense VARCHAR,\n" +
            "future_tense VARCHAR);";
    private static final String CREATE_TENSE = "CREATE TABLE IF NOT EXISTS tense\n" +
            "(verb_name VARCHAR CONSTRAINT tense_verb_name_fkey REFERENCES verb,\n" +
            "tense_name VARCHAR NOT NULL CONSTRAINT tense_tense_name_key UNIQUE,\n" +
            "first_person_singular VARCHAR,\n" +
            "second_person_singular VARCHAR,\n" +
            "third_person_singular VARCHAR,\n" +
            "first_person_plural VARCHAR,\n" +
            "second_person_plural VARCHAR,\n" +
            "third_person_plural VARCHAR);";

    private List<String> queries;
    private Iterator<String> iter;

    public CreateTableSpec() {
        this.queries = new ArrayList<>();
        this.constructQueries(null);
        this.iter = queries.iterator();
    }

    @Override
    public void constructQueries(Verb undefinedObject) {
        this.queries.add(CREATE_VERB);
        this.queries.add(CREATE_TENSE);
    }

    @Override
    public String toSqlQuery() {
        final String query = iter.next();

        System.out.println(query);
        return query;
    }

    @Override
    public boolean hasNextQuery() {
        return iter.hasNext();
    }
}
