package dev.aubique.conj.services;

import dev.aubique.conj.controller.ApiController;
import dev.aubique.conj.enums.JsonMapperType;
import dev.aubique.conj.exceptions.ResourceNotFoundException;
import dev.aubique.conj.model.VerbEntity;
import dev.aubique.conj.model.dto.VerbDto;

/**
 * Class that represents Application Layer Services
 */
public interface VerbService {

    /**
     * Handle and return a {@link VerbDto} with all possible tense groups
     * See {@code getVerbDto} method
     *
     * @return extended DTO form
     */
    VerbDto getMaxVerbDto(String verbName) throws ResourceNotFoundException;

    /**
     * Handle and get a {@link VerbDto} with a minimal set of required tense groups
     * See {@code getVerbDto} method
     *
     * @return minimal DTO form
     */
    VerbDto getMinVerbDto(String verbName) throws ResourceNotFoundException;

    /**
     * Forward a {@link VerbDto} according to the requested {@link JsonMapperType}
     *
     * @param verbName correct verb form dispatched from {@link ApiController}
     * @return DTO with the requested type for API
     * @throws ResourceNotFoundException if not found in Repo/Parser services
     */
    public VerbDto getVerbDto(String verbName, JsonMapperType type) throws ResourceNotFoundException;

    /**
     * Save {@link VerbEntity} to the Persistence
     * Should be used to store parsed verbs in DB
     *
     * @param verbObj {@link VerbEntity} object
     */
    void saveVerb(VerbEntity verbObj);
}
