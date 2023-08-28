package com.example.spring.day6.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.spring.day6.model.PageModel;

public interface PageService {
	
	List<PageModel> getUser();
	public boolean deleteUser(int babyId);
	public boolean addUser(PageModel user);
	public Page<PageModel> getAllUser(PageRequest pageRequest);

	boolean updateUser(int babyId, PageModel user);

//	public PageModel getId(int id);
	




}
