package com.techv.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techv.dao.IStudentRepositary;
import com.techv.entity.StudentEntity;

@Service
public class StudentService {
	@Autowired
	private IStudentRepositary studentDao;
	
	public Collection<StudentEntity> getAllStudents(){
		return (Collection<StudentEntity>) studentDao.findAll();
	}
	
	/**
	 * @param student
	 * addition should be possible only when a non-existing id is 
	 * provided in the request body
	 */
	public ResponseEntity<String> addStudent(StudentEntity student){
		ResponseEntity<String> responseEntity;
		if(studentDao.exists(student.getId())){
			responseEntity = new ResponseEntity<String>("Id already present. Status : "+HttpStatus.CONFLICT.toString(),HttpStatus.CONFLICT);
		} else {
			studentDao.save(student);
			responseEntity = new ResponseEntity<String>("Successfully created. Status : "+HttpStatus.CREATED.toString(),HttpStatus.CREATED);
		}
		return responseEntity;
	}
	/**
	 * @param student
	 * update should be possible only when a not null and existing 
	 * id has been provided in the request body
	 */
	public ResponseEntity<String> editStudentDetail(StudentEntity student){
		ResponseEntity<String> responseEntity;
		if(student.getId()==0){
			responseEntity = new ResponseEntity<String>("Id not provided. Status : "+HttpStatus.NOT_FOUND.toString(),HttpStatus.NOT_FOUND);
		} else if (!studentDao.exists(student.getId())){
			responseEntity = new ResponseEntity<String>("Could not find Id. Status : "+HttpStatus.NOT_FOUND.toString(),HttpStatus.NOT_FOUND);
		} else {
			studentDao.save(student);
			responseEntity = new ResponseEntity<String>("Successfully edited. Status : "+HttpStatus.OK.toString(), HttpStatus.OK);
		}
		
		return responseEntity;
	}
}
