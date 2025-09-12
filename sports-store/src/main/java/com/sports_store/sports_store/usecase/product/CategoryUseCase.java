package com.sports_store.sports_store.usecase.product;

import com.sports_store.sports_store.domain.product.Category;
import com.sports_store.sports_store.repository.product.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryUseCase {

    private final ICategoryRepository repository;
    public CategoryUseCase(ICategoryRepository aRepository){
        this.repository = aRepository;
    }

    public Category persist(Category obj){
        return repository.save(obj);
    }

    public Category findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID não existe"));
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category update(Long id, Category obj){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("ID não existe");
        }
        obj.setId(id);
        return repository.save(obj);
    }

    public void drop(Long id){
        if (!repository.existsById(id)) throw new IllegalArgumentException("Id não existe");
        repository.deleteById(id);
    }





}
