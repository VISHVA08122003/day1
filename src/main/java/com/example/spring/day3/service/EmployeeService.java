package com.example.spring.day3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.day3.model.Employee;
import com.example.spring.day3.repository.EmpRepo;

@Service
public class EmployeeService {
	@Autowired
	EmpRepo em;
	
	public Employee saveDetails(Employee E) {
		return em.save(E);
	}
	
	public List<Employee> getDetails(){
		return em.findAll();
	}

}
