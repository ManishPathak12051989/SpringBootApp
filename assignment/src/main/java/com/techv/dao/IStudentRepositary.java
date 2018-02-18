package com.techv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techv.entity.StudentEntity;

@Repository
public interface IStudentRepositary extends JpaRepository<StudentEntity, Integer>{

}
