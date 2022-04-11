package com.dev.Coffee.repository;

import com.dev.Coffee.entities.ContactEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntities, Long> {
}
