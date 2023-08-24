package com.example.spring.day4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.day4.model.StudentModel;

@Repository
public interface StudentRepo extends JpaRepository<StudentModel,Integer>{

}
