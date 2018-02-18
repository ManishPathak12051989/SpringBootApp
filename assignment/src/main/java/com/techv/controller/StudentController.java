package com.techv.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techv.entity.StudentEntity;
import com.techv.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/fetch",method = RequestMethod.GET)
	public Collection<StudentEntity> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<String> addStudent(@RequestBody StudentEntity student){
		return studentService.addStudent(student);
	}

	@RequestMapping( method = RequestMethod.PUT)
	public ResponseEntity<String> editStudentDetail(@RequestBody StudentEntity student){
		return studentService.editStudentDetail(student);
	}
}
