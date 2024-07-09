package com.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.models.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer>{

}
