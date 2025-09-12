package com.sports_store.sports_store.controller.product;

import com.sports_store.sports_store.domain.product.Product;
import com.sports_store.sports_store.usecase.product.ProductUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/product")
public class ProductController {

    private final ProductUseCase useCase;
    public ProductController(ProductUseCase aUseCase){
        this.useCase = aUseCase;
    }

    @PostMapping(value = "/persist")
    public ResponseEntity<Product> persist(@RequestBody @Valid Product obj){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(useCase.persist(obj));
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.findById(id));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.findAll());
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product obj){
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
