package com.microservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.dto.School;
import com.microservices.dto.StudentResponse;
import com.microservices.models.Student;
import com.microservices.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	public StudentRepository studentRepository;
	
	@Autowired
	public RestTemplate restTemplate;
	
	public ResponseEntity<?> createStudent(Student student)
	{
		try {
			return new ResponseEntity<Student>(studentRepository.save(student), HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> getStudentById(String id)
	{
	    Optional<Student> student = studentRepository.findById(id);
	    
	    if(student.isPresent())
	    {
	        String url = String.format("http://SCHOOLMICROSERVICES/school/%s", student.get().getSchoolId());
	        School school = restTemplate.getForObject(url, School.class);
	        StudentResponse studentResponse = new StudentResponse(
	            student.get().getId(),
	            student.get().getName(),
	            student.get().getAge(),
	            student.get().getGender(),
	            school
	        );
	        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
	    }
	    else{
	        return new ResponseEntity<>("No Student Found", HttpStatus.NOT_FOUND);
	    }
	}
	
	public ResponseEntity<?> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        if(students.size() > 0){
            return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Students",HttpStatus.NOT_FOUND);
        }
    }

	
	
}
