package dev.aubique.conj.controller;

import com.google.gson.Gson;
import dev.aubique.conj.exceptions.ResourceNotFoundException;
import dev.aubique.conj.model.VerbMax;
import dev.aubique.conj.services.VerbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private VerbServiceImpl service;

    @Autowired
    private Gson gson;

    //TODO: set apart the code for max and min
    @GetMapping({"/max/{infinitive:[a-zA-Z]+}", "/{infinitive:[a-zA-Z]+}"})
    public ResponseEntity<VerbMax> getVerbMaxRequest(@PathVariable String infinitive) {
        try {
            final VerbMax verbMax = service.getVerbMax(infinitive);
            return ResponseEntity.ok(verbMax);
        } catch (ResourceNotFoundException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
