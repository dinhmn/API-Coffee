package com.dev.Coffee.repository;

import com.dev.Coffee.entities.ProductEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntities, Long> {
}
