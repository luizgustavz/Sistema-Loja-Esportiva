package com.sports_store.sports_store.usecase.users;

import com.sports_store.sports_store.domain.users.People;
import com.sports_store.sports_store.repository.users.IPeopleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleUseCase {

    private final IPeopleRepository repository;
    public PeopleUseCase(IPeopleRepository aRepository){
        this.repository = aRepository;
    }

    @Transactional
    public People persist(People obj){
        return repository.save(obj);
    }

    public People findById(Long id){
        return repository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("ID não exixte"));
    }

    public List<People> findAll(){
        return repository.findAll();
    }

    @Transactional
    public People update(Long id, People obj){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException("Pessoa não existe");
        }
        obj.setId(id);
        return repository.save(obj);
    }

    @Transactional
    public void drop(Long id){
        if (!repository.existsById(id)) throw new IllegalArgumentException("Pessoa não existe");
        repository.deleteById(id);
    }



}
