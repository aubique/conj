package dev.aubique.conj.services;

import dev.aubique.conj.exceptions.ResourceNotFoundException;
import dev.aubique.conj.model.VerbMax;
import dev.aubique.conj.model.dto.VerbDto;
import dev.aubique.conj.repository.VerbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerbServiceImpl {

    @Autowired
    private VerbRepository repo;

    @Autowired
    private ParserService parser;

    @Autowired
    private MapperService<VerbMax, VerbDto> mapper;

    public VerbMax getVerbById(Long verbId) {
        return repo.findById(verbId).get();
    }

    private VerbMax findVerb(String verbName)
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

    private Optional<VerbMax> doInternalSearch(String name) {
        return repo.findFirstByName(name);
    }

    private Optional<VerbMax> doExternalSearch(String name) {
        final VerbMax verbObj = parser.parseVerb(name);

        if (verbObj == null)
            return Optional.empty();

        saveVerb(verbObj);
        return doInternalSearch(verbObj.getName());
//        return Optional.of(verbObj);
    }

    public void saveVerb(VerbMax verbObj) {
        if (!repo.existsByName(verbObj.getName()))
            repo.save(verbObj);
    }
}
