package com.example.spring.day3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.day3.model.Employee;

public interface EmpRepo extends JpaRepository<Employee,Integer>{

}
