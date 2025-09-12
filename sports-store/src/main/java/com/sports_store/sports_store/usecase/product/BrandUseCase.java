package com.sports_store.sports_store.usecase.product;

import com.sports_store.sports_store.domain.product.Brand;
import com.sports_store.sports_store.repository.product.IBrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandUseCase {

    private final IBrandRepository repository;
    public BrandUseCase(IBrandRepository aRepository){
        this.repository = aRepository;
    }

    public Brand persist(Brand obj){
        return repository.save(obj);
    }

    public Brand findById(Long id){
        return repository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("ID não encontrado"));
    }

    public List<Brand> findAll(){
        return repository.findAll();
    }

    public Brand update(Long id, Brand obj){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Id não existe");
        }
        obj.setId(id);
        return repository.save(obj);
    }

    public void drop(Long id){
        repository.deleteById(id);
    }




}
