package com.example.demo.entities.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;

public interface UserDAO extends JpaRepository<User, Long>{

}
