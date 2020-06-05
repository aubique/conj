package dev.aubique.conj.mapper;

import dev.aubique.conj.mapper.impl.MaxMapper;
import dev.aubique.conj.mapper.impl.MinMapper;
import dev.aubique.conj.model.dto.VerbDto;

/**
 * Interface that represents methods for mapping from Entities to DTO
 * Take a look at the implementations: {@link MaxMapper}, {@link MinMapper}
 */
public interface DefaultMapper {

    VerbDto map();
}
