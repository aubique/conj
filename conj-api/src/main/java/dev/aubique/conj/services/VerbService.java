package dev.aubique.conj.services;

import dev.aubique.conj.controller.ApiController;
import dev.aubique.conj.exceptions.ResourceNotFoundException;
import dev.aubique.conj.model.VerbEntity;
import dev.aubique.conj.model.dto.VerbDto;

/**
 * Class that represents Application Layer Services
 */
public interface VerbService {

    /**
     * Handle and return a {@link VerbDto} with all possible tense groups
     *
     * @param verbName correct verb form dispatched from {@link ApiController}
     * @return extended DTO form for API
     * @throws ResourceNotFoundException if not found in Repo/Parser services
     */
    VerbDto getMaxVerbDto(String verbName) throws ResourceNotFoundException;

    /**
     * Handle and get a {@link VerbDto} with a minimal set of required tense groups
     *
     * @param verbName correct verb form dispatched from {@link ApiController}
     * @return minimal DTO form for API
     * @throws ResourceNotFoundException if not found in Repo/Parser services
     */
    VerbDto getMinVerbDto(String verbName) throws ResourceNotFoundException;

    /**
     * Save {@link VerbEntity} to the Persistence
     * Should be used to store parsed verbs in DB
     *
     * @param verbObj {@link VerbEntity} object
     */
    void saveVerb(VerbEntity verbObj);
}
