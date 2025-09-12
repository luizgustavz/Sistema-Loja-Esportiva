package com.sports_store.sports_store.repository.product;

import com.sports_store.sports_store.domain.product.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {
}
