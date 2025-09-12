package com.sports_store.sports_store.usecase.state;

import com.sports_store.sports_store.domain.state.City;
import com.sports_store.sports_store.repository.ICityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityUseCase {

    private final ICityRepository repository;
    public CityUseCase(ICityRepository aRepository){
        this.repository = aRepository;
    }

    @Transactional
    public City persist(City obj){
        return repository.save(obj);
    }

    public City findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não existe cidade com esse id"));
    }

    public City findByName(String name){
        return repository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Cidade não existe"));
    }

    public List<City> findAll(){
        return repository.findAll();
    }

    @Transactional
    public City patch(Long id, City obj){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("ID não existe!");
        }
        obj.setId(id);
        return repository.save(obj);
    }

    @Transactional
    public void drop(Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Cidade não existe.");
        }
        repository.deleteById(id);
    }

}
