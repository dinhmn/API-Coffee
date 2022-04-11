package com.dev.Coffee.repository;

import com.dev.Coffee.entities.CategoriesEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntities, Long> {
}
