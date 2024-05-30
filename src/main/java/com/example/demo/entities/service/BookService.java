package com.example.demo.entities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Book;
import com.example.demo.entities.dao.BookDAO;

@Service
public class BookService {

	@Autowired
	private BookDAO bookDao;

	public List<Book> getBooks() {
		return bookDao.findAll();
	}

	public void deleteBook(Long id) {
		bookDao.deleteById(id);
	}

	public Book insertBook(Book book) {
		return bookDao.save(book);
	}

}
