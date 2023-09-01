package com.example.spring.day8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.day8.model.BikeModel;
import com.example.spring.day8.repository.BikeRepo;

@Service
public class BikeService {
	
	@Autowired
	BikeRepo br;
	public BikeModel add(BikeModel s) {
		return br.save(s);
	}
	public List<BikeModel> getByYear(int year){
		return br.getByYear(year);
	}
	public List<BikeModel> getByYearAndName(int year,String name){
		return br.getByYearAndName(year, name);
	}
	public List<BikeModel> getByName(String name){
		return br.getByName(name);
	}

}
