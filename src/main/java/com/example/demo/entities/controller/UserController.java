package com.example.demo.entities.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.entities.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getBooks(){
		List<User> list = new ArrayList<User>();
		try {
			list = userService.getUsers();
			return new ResponseEntity<List<User>>(list, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<List<User>>(list, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@RequestParam Long id) {
		try {
			userService.deleteUser(id);
			return new ResponseEntity<String>("Delete user with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error: " + id, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping
	public ResponseEntity<User> insertUser(@RequestBody User user){
		User userTmp = null;
		try {
			userTmp = userService.insertUser(user);
			return new ResponseEntity<User>(userTmp, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<User>(userTmp, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User userTmp = null;
		try {
			userTmp = userService.insertUser(user);
			return new ResponseEntity<User>(userTmp, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<User>(userTmp, HttpStatus.BAD_REQUEST);
		}
	}

}
