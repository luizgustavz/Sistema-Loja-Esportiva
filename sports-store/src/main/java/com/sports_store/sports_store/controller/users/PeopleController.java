package com.sports_store.sports_store.controller.users;

import com.sports_store.sports_store.domain.users.People;
import com.sports_store.sports_store.usecase.users.PeopleUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/users")
public class PeopleController {

    private final PeopleUseCase useCase;
    public PeopleController(PeopleUseCase aUseCase){
        this.useCase = aUseCase;
    }

    @PostMapping(value = "/persist")
    public ResponseEntity<People> persist(@RequestBody @Valid People obj){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(useCase.persist(obj));
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<People> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.findById(id));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<People>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.findAll());
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<People> update(@PathVariable Long id, @RequestBody People obj){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.update(id, obj));
    }

    @DeleteMapping(value = "/drop/id")
    public ResponseEntity<Void> drop(@RequestParam Long id){
        useCase.drop(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

}
