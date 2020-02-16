package dev.aubique.conj.servlets;

import dev.aubique.conj.repository.VerbRepository;
import dev.aubique.conj.specifications.CreateTableSpec;
import dev.aubique.conj.specifications.SelectAllSpec;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImpl implements ServletContextListener {

    public static ServletContext context;

    /**
     * Load a static repository with complete list of entities
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        VerbRepository objRepository = new VerbRepository();

        context = sce.getServletContext();
        // Query to select all from tense-table
        objRepository.add(new CreateTableSpec());
        objRepository.query(new SelectAllSpec());

        context.setAttribute("repository", objRepository);
        context.log("The repository has been loaded...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context = null;
    }
}
