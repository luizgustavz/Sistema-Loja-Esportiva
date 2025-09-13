package com.sports_store.sports_store.repository.users;

import com.sports_store.sports_store.domain.users.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeopleRepository extends JpaRepository<People, Long> {
}
