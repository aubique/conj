package dev.aubique.conj.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.aubique.conj.entity.Verb;
import dev.aubique.conj.entity.VerbFactoryManger;
import dev.aubique.conj.repository.VerbRepository;
import dev.aubique.conj.specifications.InsertSpec;
import dev.aubique.conj.specifications.SelectAllSpec;
import dev.aubique.conj.specifications.SelectByNameSpec;
import dev.aubique.conj.specifications.SqlSpecification;

import javax.servlet.ServletContext;
import java.util.Map;
import java.util.TreeMap;

public class ApiService {

    public Verb dummyObj;
    private ServletContext context;
    private SqlSpecification specification;
    private VerbRepository repository;
    private ParserService parser;

    public ApiService() {
        this.context = null;
        dummyObj = new VerbFactoryManger().construct();
        System.out.println("\nApiService{} has been created");
    }

    public String findOne(String verbName) {
        reloadRepository();
        this.specification = new SelectByNameSpec(verbName);
        this.parser = new ParserService(verbName);
        String query = getQueryResult(specification);

        if (query == null) {
            Verb parsedVerb = new Verb(verbName, parser.parse());
            this.addOne(parsedVerb);
            return getParsedResult(parsedVerb);
        }
        return query;
    }

    public String findAll() {
        reloadRepository();
        this.specification = new SelectAllSpec();
        return getQueryResult(specification);
    }

    public void addOne(Verb verbToAdd) {
        reloadRepository();
        this.specification = new InsertSpec(verbToAdd);
        this.repository.add(specification);
    }

    private void reloadRepository() {
        this.repository = (VerbRepository) context.getAttribute("repository");
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    public boolean hasContext() {
        return this.context != null;
    }

    private String getParsedResult(Verb parsedVerb) {
        final Map<String, Verb> dictJson = new TreeMap<>();
        dictJson.put(parsedVerb.getVerbName(), parsedVerb);
        System.out.println(parsedVerb.getVerbName() + " has been parsed");
        try {
            return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(dictJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert queryResult to JSON");
        }
    }

    private String getQueryResult(SqlSpecification specification) {
        Map<String, Verb> queryResult = repository.query(specification);
        if (queryResult.isEmpty()) {
            return null;
        }
        try {
            //TODO remove sout
            System.out.println(queryResult);
//            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(queryResult));
            return new ObjectMapper().writeValueAsString(queryResult);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert queryResult to JSON");
        }
    }
}
