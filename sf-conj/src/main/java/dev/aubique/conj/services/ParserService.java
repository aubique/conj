package dev.aubique.conj.services;

import dev.aubique.conj.model.VerbMax;

public interface ParserService {

    VerbMax getParsedVerb(String verbName);
}
