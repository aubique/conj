package dev.aubique.conj.listener;

import dev.aubique.conj.model.Verb;
import dev.aubique.conj.repository.CanonRepository;
import dev.aubique.conj.repository.VerbRepository;

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
        CanonRepository<Verb> objRepository = new VerbRepository();
        context = sce.getServletContext();
        // Query to select all from tense-table
//        objRepository.query(new SelectAllSpec());
        context.setAttribute("repository", objRepository);
        context.log("The repository has been loaded...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context = null;
    }
}
