package com.example.demo.entities.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Book;

public interface BookDAO extends JpaRepository<Book, Long>{

}
