package com.sports_store.sports_store.usecase.product;

import com.sports_store.sports_store.domain.product.Product;
import com.sports_store.sports_store.repository.product.IProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUseCase {

    private final IProductRepository repository;
    public ProductUseCase(IProductRepository aRepository){
        this.repository = aRepository;
    }

    @Transactional
    public Product persist(Product obj){
        return repository.save(obj);
    }

    public Product findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id não existe"));
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Product update(Long id, Product obj){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("ID não existe");
        }
        obj.setId(id);
        return repository.save(obj);
    }

    @Transactional
    public void drop(Long id){
        if (!repository.existsById(id)) throw new IllegalArgumentException("Id não existe");
        repository.deleteById(id);
    }

}
