package com.example.spring.day6.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.day6.model.PageModel;
import com.example.spring.day6.service.PageService;

@RestController
@RequestMapping("/api/v1/user")
public class PageController {
	
	@Autowired
	private PageService pageService;
	
	@GetMapping("/getUser")
    public ResponseEntity<PageModel> getUser(@RequestBody PageModel user){
		return ResponseEntity.status(200).body(user);
	}

	
	@GetMapping("/gettingAllUser")
	 public ResponseEntity<Page<PageModel>> getAllUser(
		@RequestParam(defaultValue = "0") int page, 
		@RequestParam(defaultValue = "10") int size,
		@RequestParam(defaultValue = "babyId") String sortField,
		@RequestParam(defaultValue = "asc") String sortOrder
		){
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder),sortField));
		return ResponseEntity.status(200).body(pageService.getAllUser(pageRequest));
	}
	
	@PostMapping("/addingUser")
    public ResponseEntity<String> addUser(@RequestBody PageModel user){
   	 boolean dataSaved = pageService.addUser(user);
   	 if(dataSaved) {
   		 return ResponseEntity.status(200).body("User added successfully!");
   	 }
   	 else {
   		 return ResponseEntity.status(404).body("Something went wrong!");
   	 }
   	 
    }
    
    @PutMapping("/updateUser/{idno}")
    public ResponseEntity<String> updateUser(@PathVariable int babyId,@RequestBody PageModel user){
   	 boolean userData = pageService.updateUser(babyId,user);
   	 if(userData) {
   		 return ResponseEntity.status(200).body("User updated successfully");
   	 }
   	 else {
   		 return ResponseEntity.status(404).body("nO RECORD FOUND TO BE updated");
   	 }
   	
    }
    

    @DeleteMapping("/deleteUser/{idno}")
    public ResponseEntity<String> deleteUser(@PathVariable int babyId){
   	 boolean userDeleted = pageService.deleteUser(babyId);
   	 if(userDeleted) {
   		 return ResponseEntity.status(200).body("User deleted successfully");
   	 }
   	 else {
   		 return ResponseEntity.status(200).body("User not deleted successfully");
   	 }
    }

}
