package com.example.spring.day5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.day5.model.BookModel;
import com.example.spring.day5.service.BookService;


@RestController
@RequestMapping("/api/v1/user")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody BookModel bookmodel){
		boolean datasaved=bookService.addUser(bookmodel);
		if(datasaved) {
			return ResponseEntity.status(200).body("user added successfully");
		}
		else {
			return ResponseEntity.status(404).body("user not added successfully");
		}
	}
	
	   @PutMapping("/updateUser/{id}")
	     
	     public ResponseEntity<String> updateUser(@PathVariable int id,@RequestBody BookModel bookmodel){
	    	 boolean userData = bookService.updateUser(id,bookmodel);
	    	 if(userData){
	    		 return ResponseEntity.status(200).body("User updated successfully");
	    	 }
	    	 else {
	    		 return ResponseEntity.status(404).body("nO RECORD FOUND TO BE updated");
	    	 }

	     }
     @DeleteMapping("/deleteUser/{id}")
     public ResponseEntity<String> deleteUser(@PathVariable int id){
    	 boolean userDeleted = bookService.deleteUser(id);
    	 if(userDeleted) {
    		 return ResponseEntity.status(200).body("User deleted successfully");
    	 }
    	 else {
    		 return ResponseEntity.status(200).body("User not deleted successfully");
    	 }
     }

	
}
