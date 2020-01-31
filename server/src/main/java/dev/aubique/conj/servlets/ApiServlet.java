package dev.aubique.conj.servlets;

import com.google.gson.Gson;
import dev.aubique.conj.entity.Verb;
import dev.aubique.conj.repository.CanonRepository;
import dev.aubique.conj.repository.VerbRepository;
import dev.aubique.conj.services.ApiService;
import dev.aubique.conj.specifications.SelectByNameSpec;
import dev.aubique.conj.specifications.SqlSpecification;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.sql.Connection;

@Path("/find")
public class ApiFind {

    @Context
    private ServletContext context;
    private CanonRepository<Verb> repositoryObj;//
    private SqlSpecification specification;
    private Connection connection;
    private ApiService api = new ApiService();

    @GET
    @Path("/all")
    @Produces("application/json")
    public String findAll() {
        this.checkContext();
        // It works!
        this.api.findAll();
        System.out.println(this.context.getAttribute("apiServiceVar"));
        return null;
    }

    private void checkContext() {
        if (!this.api.hasContext()) {
            this.api.setContext(this.context);
        }
    }

    @GET
    @Path("/{param}")
    @Produces("application/json")
    public String findVerb(@PathParam("param") String verbName) {
        this.specification = new SelectByNameSpec(verbName);
        return getQueryResult(specification);
    }

    private String getQueryResult(SqlSpecification specification) {
        this.repositoryObj = (VerbRepository) context.getAttribute("repository");
        return new Gson().toJson(repositoryObj.query(specification));
    }
}
