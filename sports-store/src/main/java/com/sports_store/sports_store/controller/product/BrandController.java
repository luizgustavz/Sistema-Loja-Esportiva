package com.sports_store.sports_store.controller.product;

import com.sports_store.sports_store.domain.product.Brand;
import com.sports_store.sports_store.repository.product.IBrandRepository;
import com.sports_store.sports_store.usecase.product.BrandUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/brand")
public class BrandController {

    private final BrandUseCase useCase;
    public BrandController(BrandUseCase aUseCase){
        this.useCase = aUseCase;
    }

    @PostMapping(value = "/persist")
    public ResponseEntity<Brand> persist(@RequestBody Brand obj){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(useCase.persist(obj));
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Brand> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.findById(id));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Brand>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.findAll());
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Brand> update(@PathVariable Long id, @RequestBody Brand obj){
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
