package com.microservices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "school")
@Data
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String schoolName;
    private String location;
    private String principalName;
}
