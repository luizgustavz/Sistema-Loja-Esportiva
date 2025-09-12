package com.sports_store.sports_store.repository.state;

import com.sports_store.sports_store.domain.state.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICityRepository extends JpaRepository<City, Long> {

    Optional<City> findByName(String name);
}
