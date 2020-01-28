package dev.aubique.conj.servlets;

import com.google.gson.Gson;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("/find")
public class ApiFind {

    @GET
    @Path("/all")
    @Produces("application/json")
    public String findAll(@Context ServletContext context) {
        return new Gson().toJson(context.getAttribute("repository"));
    }

    @GET
    @Path("/{param}")
    @Produces("application/json")
    public String findVerb(@PathParam("param") String verbName) {
        return "";
    }
}
