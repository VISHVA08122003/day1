package com.example.spring.day5.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.day5.model.BookModel;
import com.example.spring.day5.repository.BookRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public boolean addUser(BookModel bookmodel) {
		boolean userExists = bookRepository.existsById(bookmodel.getId());
		if(!userExists) {
			bookRepository.save(bookmodel);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateUser(int id, BookModel bookmodel) {
		//userRepository.saveAndFlush(user);
		Optional<BookModel> existingUserOptional=bookRepository.findById(id);
		if(existingUserOptional.isPresent()){
		BookModel userExists = existingUserOptional.get();
		userExists.setBookName(bookmodel.getBookName());
		userExists.setPrice(bookmodel.getPrice());
		userExists.setQuantity(bookmodel.getQuantity());
		userExists.setAuthorName(bookmodel.getAuthorName());
		bookRepository.save(userExists);
		return true;
	}else {
		return false;
		}
	}

	@Override
	public boolean deleteUser(int id) {
		Optional<BookModel>existingUserOptional = bookRepository.findById(id);
		if(existingUserOptional.isPresent()) {
			bookRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

}
