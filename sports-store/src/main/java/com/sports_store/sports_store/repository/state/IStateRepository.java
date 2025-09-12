package com.sports_store.sports_store.repository.state;

import com.sports_store.sports_store.domain.state.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStateRepository extends JpaRepository<State, Long> {

    Optional<State> findByName(String name);

}
