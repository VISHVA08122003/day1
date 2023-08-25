package com.example.spring.day5.service;

import com.example.spring.day5.model.BookModel;


public interface BookService {

	public boolean addUser(BookModel bookmodel);
	public boolean updateUser(int id,BookModel bookmodel);
	public boolean deleteUser(int id);

}
