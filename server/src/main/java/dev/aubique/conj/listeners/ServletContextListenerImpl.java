package dev.aubique.conj.listeners;

import dev.aubique.conj.models.Verb;
import dev.aubique.conj.repositories.CanonRepository;
import dev.aubique.conj.repositories.VerbRepository;
import dev.aubique.conj.specifications.SelectAllSpecification;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImpl implements ServletContextListener {

    public static ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        CanonRepository<Verb> repository = new VerbRepository();
        repository.query(new SelectAllSpecification());
        context.setAttribute("repository", repository);
        context.log("The repository has been loaded...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context = null;
    }
}
