package com.microservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.models.School;
import com.microservices.repositories.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;
	
	public School addSchool(School school)
	{
		return schoolRepository.save(school);
	}
	
	public List<School> getAllSchool()
	{
		return schoolRepository.findAll();
	}
	
	public School getSchoolById(Integer id)
	{
		return schoolRepository.findById(id).orElse(null);
	}
}
