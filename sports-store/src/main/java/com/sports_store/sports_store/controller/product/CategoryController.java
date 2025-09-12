package com.sports_store.sports_store.controller.product;

import com.sports_store.sports_store.domain.product.Category;
import com.sports_store.sports_store.usecase.product.CategoryUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/category")
public class CategoryController {


    private final CategoryUseCase useCase;
    public CategoryController(CategoryUseCase aUseCase){
        this.useCase = aUseCase;
    }

    @PostMapping(value = "/persist")
    public ResponseEntity<Category> persist(@RequestBody Category obj){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(useCase.persist(obj));
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Category> findByI(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.findById(id));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCase.findAll());
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category obj){
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
