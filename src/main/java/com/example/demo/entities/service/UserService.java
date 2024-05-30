package com.example.demo.entities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.entities.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public List<User> getUsers() {
		return userDAO.findAll();
	}

	public void deleteUser(Long id) {
		userDAO.deleteById(id);
	}

	public User insertUser(User user) {
		return userDAO.save(user);
	}


}
