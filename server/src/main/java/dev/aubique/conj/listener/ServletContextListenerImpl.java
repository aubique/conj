package dev.aubique.conj.listener;

import dev.aubique.conj.model.Verb;
import dev.aubique.conj.repository.CanonRepository;
import dev.aubique.conj.repository.VerbRepository;
import dev.aubique.conj.specifications.SelectAllSpecification;

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
        context = sce.getServletContext();
        CanonRepository<Verb> repository = new VerbRepository();
        // Query to select all from tense-table
        repository.query(new SelectAllSpecification());
        context.setAttribute("repository", repository);
        context.log("The repository has been loaded...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context = null;
    }
}
