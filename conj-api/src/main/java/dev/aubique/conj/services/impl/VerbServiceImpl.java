package dev.aubique.conj.services.impl;

import dev.aubique.conj.model.enums.JsonMapperType;
import dev.aubique.conj.exceptions.ResourceNotFoundException;
import dev.aubique.conj.model.VerbEntity;
import dev.aubique.conj.model.dto.VerbDto;
import dev.aubique.conj.repository.VerbRepository;
import dev.aubique.conj.services.MapperService;
import dev.aubique.conj.services.ParserService;
import dev.aubique.conj.services.VerbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerbServiceImpl implements VerbService {

    @Autowired
    private VerbRepository repo;

    @Autowired
    private ParserService parser;

    @Autowired
    private MapperService<VerbEntity, VerbDto> mapper;

    public VerbEntity getVerbById(Long verbId) {
        return repo.findById(verbId).get();
    }

    private VerbEntity findVerb(String verbName)
            throws ResourceNotFoundException {
        return doInternalSearch(verbName)
                .or(() -> doExternalSearch(verbName))
                .orElseThrow(ResourceNotFoundException::new);
    }

    public VerbDto getMaxVerbDto(String verbName)
            throws ResourceNotFoundException {
        return mapper.mapToMax(findVerb(verbName));
    }

    public VerbDto getMinVerbDto(String verbName)
            throws ResourceNotFoundException {
        return mapper.mapToMin(findVerb(verbName));
    }

    public VerbDto getVerbDto(String verbName, JsonMapperType type)
            throws ResourceNotFoundException {
        switch (type) {
            case EXTENDED:
                return getMaxVerbDto(verbName);
            case MINIMAL:
                return getMinVerbDto(verbName);
            default:
                throw new RuntimeException("JsonMapperType enum is not found");
        }
    }

    private Optional<VerbEntity> doInternalSearch(String name) {
        return repo.findFirstByName(name);
    }

    private Optional<VerbEntity> doExternalSearch(String name) {
        final VerbEntity verbObj = parser.parseVerb(name);

        if (verbObj == null)
            return Optional.empty();

        saveVerb(verbObj);
        return doInternalSearch(verbObj.getName());
//        return Optional.of(verbObj);
    }

    public void saveVerb(VerbEntity verbObj) {
        if (!repo.existsByName(verbObj.getName()))
            repo.save(verbObj);
    }
}
