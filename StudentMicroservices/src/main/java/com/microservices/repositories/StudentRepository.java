package com.microservices.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservices.models.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

}
