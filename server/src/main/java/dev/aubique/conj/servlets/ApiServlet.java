package dev.aubique.conj.servlets;

import com.sun.jersey.core.header.MediaTypes;
import dev.aubique.conj.entity.Verb;
import dev.aubique.conj.repository.CanonRepository;
import dev.aubique.conj.services.ApiService;
import dev.aubique.conj.specifications.SqlSpecification;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.sql.Connection;

@Path("/find")
public class ApiServlet {

    @Context
    private ServletContext context;
    private CanonRepository<Verb> repositoryObj;//
    private SqlSpecification specification;
    private Connection connection;
    private ApiService api = new ApiService();

    private void checkContext() {
        if (!this.api.hasContext()) {
            this.api.setContext(this.context);
        }
    }

    private void testFunc() {
        System.out.println("\n\n\nTEST TEST TEST\n\n\n");
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public String findAll() {
        this.checkContext();
//        System.out.println(this.context.getAttribute("apiServiceVar"));
        return this.api.findAll();
    }

    @GET
    @Path("/{param}")
    @Produces("application/json")
    public String findVerb(@PathParam("param") String verbName) {
        this.checkContext();
        return this.api.findOne(verbName);
    }

    @GET
    @Path("/add")
    @Produces(MediaTypes.WADL_JSON_STRING)
    public String addOne() {
        this.checkContext();
        this.api.addOne();
        return "The verb «Manger» has been added to the DB";
    }
}
