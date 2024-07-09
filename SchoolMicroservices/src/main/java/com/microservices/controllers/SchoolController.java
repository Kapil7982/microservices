package com.microservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.models.School;
import com.microservices.services.SchoolService;


@RequestMapping(value="/school")
@RestController
public class SchoolController {

	@Autowired
	private SchoolService schoolService;
	
	@PostMapping
	public School addSchool(@RequestBody School school)
	{
		return schoolService.addSchool(school);
	}
	
	@GetMapping
	public List<School> getallSchool()
	{
		return schoolService.getAllSchool();
	}
	
	@GetMapping("/{id}")
	public School getSchoolById(@PathVariable Integer id)
	{
		return schoolService.getSchoolById(id);
	}
}
