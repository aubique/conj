package dev.aubique.conj.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.aubique.conj.entity.VerbFactoryManger;
import dev.aubique.conj.entity.Verb;
import dev.aubique.conj.repository.VerbRepository;
import dev.aubique.conj.specifications.InsertSpec;
import dev.aubique.conj.specifications.SelectAllSpec;
import dev.aubique.conj.specifications.SelectByNameSpec;
import dev.aubique.conj.specifications.SqlSpecification;

import javax.servlet.ServletContext;
import java.util.Map;

public class ApiService {

    public Verb dummyObj;
    private ServletContext context;
    private SqlSpecification specification;
    private VerbRepository repository;

    public ApiService() {
        this.context = null;
        dummyObj = new VerbFactoryManger().construct();
        System.out.println("\nApiService{} has been created");
    }

    public String findOne(String verbName) {
        this.specification = new SelectByNameSpec(verbName);
        return getQueryResult(specification);
    }

    public String findAll() {
        this.specification = new SelectAllSpec();
        return getQueryResult(specification);
    }

    public void addOne() {
        this.specification = new InsertSpec(dummyObj);
        this.repository = (VerbRepository) context.getAttribute("repository");
        this.repository.add(specification);
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    public boolean hasContext() {
        return this.context != null;
    }

    private String getQueryResult(SqlSpecification specification) {
        this.repository = (VerbRepository) context.getAttribute("repository");
        try {
            Map<String, Verb> queryResult = repository.query(specification);
//            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(queryResult));
            return new ObjectMapper().writeValueAsString(queryResult);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert queryResult to JSON");
        }
    }
}
