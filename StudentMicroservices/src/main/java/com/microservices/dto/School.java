package com.microservices.dto;

import lombok.Data;

@Data
public class School {
    private int id;
    private String schoolName;
    private String location;
    private String principalName;
}
