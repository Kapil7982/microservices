package com.microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentResponse {
    private String id;
    private String name;
    private int age;
    private String gender;
    private School school;
    
	public StudentResponse(String id, String name, int age, String gender, School school) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.school = school;
	}
    
    
}
