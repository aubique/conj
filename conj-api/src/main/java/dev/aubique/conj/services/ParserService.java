package dev.aubique.conj.services;

import dev.aubique.conj.model.VerbEntity;

/**
 * Service to parse {@link VerbEntity} from the external sources
 */
public interface ParserService {

    /**
     * Get the parsed {@link VerbEntity}
     *
     * @param verbName correct form of the verb
     * @return Verb entity to be handled by {@link VerbService}
     */
    VerbEntity parseVerb(String verbName);
}
