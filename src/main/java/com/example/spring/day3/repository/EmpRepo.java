package com.example.spring.day3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.day3.model.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer>{

}
