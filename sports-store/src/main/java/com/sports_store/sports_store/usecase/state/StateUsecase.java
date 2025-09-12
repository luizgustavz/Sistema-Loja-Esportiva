package com.sports_store.sports_store.usecase.state;

import com.sports_store.sports_store.domain.state.State;
import com.sports_store.sports_store.repository.IStateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateUsecase {

    private final IStateRepository repository;

    public StateUsecase(IStateRepository IRepository){
        this.repository = IRepository;
    }

    public State persist(State obj){
        return repository.save(obj);
    }

    public State findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public State findByName(String name){
        return repository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public List<State> findAll(){
        return repository.findAll();
    }

    public State patch(Long id, State obj){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException();
        }
        obj.setId(id);
        return repository.save(obj);
    }

    public void drop(Long id){
        if (!repository.existsById(id)){
            throw new IllegalArgumentException();
        }
        repository.deleteById(id);
    }
}
