package dev.aubique.conj.controller;

import com.google.gson.Gson;
import dev.aubique.conj.exceptions.ResourceNotFoundException;
import dev.aubique.conj.model.dto.VerbDto;
import dev.aubique.conj.services.VerbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller used to showcase the REST API
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class ApiController {

    @Autowired
    private VerbService service;

    @Autowired
    private Gson gson;

    @GetMapping({"/max/{infinitive:[a-zA-Z]+}", "/{infinitive:[a-zA-Z]+}"})
    public ResponseEntity<VerbDto> getVerbMaxRequest(@PathVariable String infinitive) {
        try {
            final var verbMax = service.getMaxVerbDto(infinitive);
            return ResponseEntity.ok(verbMax);
        } catch (ResourceNotFoundException ex) {
            // Not Found (404)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping({"/min/{infinitive:[a-zA-Z]+}"})
    public ResponseEntity<VerbDto> getVerbMinRequest(@PathVariable String infinitive) {
        try {
            final var verbMax = service.getMinVerbDto(infinitive);
            return ResponseEntity.ok(verbMax);
        } catch (ResourceNotFoundException ex) {
            // Not Found (404)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
