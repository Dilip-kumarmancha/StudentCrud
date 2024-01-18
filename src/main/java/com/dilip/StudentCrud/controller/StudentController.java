package com.dilip.StudentCrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilip.StudentCrud.beans.Student;
import com.dilip.StudentCrud.service.StudentService;

@RestController
@RequestMapping("/Students")
public class StudentController {
	
	  @Autowired
	 StudentService studentservice;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = studentservice.getAll();
		return new ResponseEntity<>(students , HttpStatus.OK);
	}
	     @GetMapping("/{id}")
	public Optional<Student> getStudentbyId(@PathVariable  int id  ){
		Optional <Student> student1=studentservice.findbyId(id);
		return student1;
	}
	     
	     
	     @PostMapping()
	     public ResponseEntity<Student> createStudent(@RequestBody Student student ){
	    	 Student Createdstudent = studentservice.insertStudent(student);
	    	 return new ResponseEntity<>(Createdstudent , HttpStatus.CREATED);
	    	 
	    	 
	     }
	     
	     @PutMapping(value = "/{id}", consumes = "application/json")
	 public  ResponseEntity<Student> UpdateStudent(@PathVariable int id , @RequestBody Student student ){
	    	 
	     Student Updatedstudent= studentservice.updateStudent(id, student);
	     if(Updatedstudent!=null) {
	    	 return new ResponseEntity<>(Updatedstudent , HttpStatus.OK);
	    	 
	     }
	     else {
	    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	 
	 }
	     
	     @DeleteMapping("/{id}")
	     public ResponseEntity<Void> deletecityByid(@PathVariable int id ){
	    	 boolean deletedstudent=studentservice.deletebyId(id);
	    	 if(deletedstudent) {
	    		 return new ResponseEntity<>(HttpStatus.OK);
	    	 }
	    	 else {
	    		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    		 
	    	 }
	    	 
	    		 
	    	 
	     }

}
