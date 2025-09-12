package com.sports_store.sports_store.controller.state;

import com.sports_store.sports_store.domain.state.City;
import com.sports_store.sports_store.usecase.state.CityUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/city")
public class CityController {

    private final CityUseCase useCase;

    public CityController(CityUseCase aUseCase){
        this.useCase = aUseCase;
    }

    @PostMapping(value = "/persist")
    public ResponseEntity<City> persist(@RequestBody @Valid City obj){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(useCase.persist(obj));
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<City> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.findById(id));
    }

    @GetMapping(value = "/list/name")
    public ResponseEntity<City> findByName(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.findByName(name));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<City>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.findAll());
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<City> put(@PathVariable @Valid Long id, @RequestBody City obj){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.patch(id, obj));
    }

    @DeleteMapping(value = "/drop/{id}")
    public ResponseEntity<Void> drop(@PathVariable Long id){
        useCase.drop(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

}
