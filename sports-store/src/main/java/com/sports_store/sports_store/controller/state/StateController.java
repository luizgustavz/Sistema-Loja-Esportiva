package com.sports_store.sports_store.controller;

import com.sports_store.sports_store.domain.state.State;
import com.sports_store.sports_store.usecase.state.StateUsecase;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/state")
public class StateController {

    private final StateUsecase usecase;

    public StateController(StateUsecase aUsecase){
        this.usecase = aUsecase;
    }

    @Transactional
    @PostMapping(value = "/s")
    public ResponseEntity<State> persist(@RequestBody @Valid State obj){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usecase.persist(obj));
    }

    @GetMapping(value = "/l/{id}")
    public ResponseEntity<State> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(usecase.findById(id));
    }

    @GetMapping(value = "/l/n/")
    public ResponseEntity<State> findByName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK)
                .body(usecase.findByName(name));
    }

    @GetMapping(value = "/l/")
    public ResponseEntity<List<State>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(usecase.findAll());
    }

    @Transactional
    @PutMapping(value = "/patch/{id}")
    public ResponseEntity<State> patch(@PathVariable @Valid Long id, @RequestBody State obj){
        return ResponseEntity.status(HttpStatus.OK)
                .body(usecase.patch(id, obj));
    }

    @Transactional
    @DeleteMapping(value = "/drop/{id}")
    public ResponseEntity<Void> drop(@PathVariable Long id){
        usecase.drop(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }









}
