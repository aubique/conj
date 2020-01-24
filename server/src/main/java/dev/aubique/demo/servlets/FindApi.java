package dev.aubique.demo.servlets;

import com.google.gson.Gson;
import dev.aubique.demo.repositories.VerbRepoFromMemoryImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/find")
public class FindApi {

    private VerbRepoFromMemoryImpl verbRepository = new VerbRepoFromMemoryImpl();

    @GET
    @Path("/all")
    @Produces("application/json")
    public String findAll() {
        return new Gson().toJson(verbRepository.findAll());
    }

    @GET
    @Path("/{param}")
    @Produces("application/json")
    public String findVerb(@PathParam("param") String verbName) {
        return new Gson().toJson(verbRepository.findVerb(verbName));
    }
}
