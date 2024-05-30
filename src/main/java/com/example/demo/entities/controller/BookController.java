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

import com.example.demo.entities.Book;
import com.example.demo.entities.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> list = new ArrayList<Book>();
		try {
			list = bookService.getBooks();
			return new ResponseEntity<List<Book>>(list, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<List<Book>>(list, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@RequestParam Long id) {
		try {
			bookService.deleteBook(id);
			return new ResponseEntity<String>("Delete book with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error: " + id, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping
	public ResponseEntity<Book> insertBook(@RequestBody Book book){
		Book bookTmp = null;
		try {
			bookTmp = bookService.insertBook(book);
			return new ResponseEntity<Book>(bookTmp, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<Book>(bookTmp, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping
	public ResponseEntity<Book> updateBook(@RequestBody Book book){
		Book bookTmp = null;
		try {
			bookTmp = bookService.insertBook(book);
			return new ResponseEntity<Book>(bookTmp, HttpStatus.OK); 
		} catch (Exception e) {
			return new ResponseEntity<Book>(bookTmp, HttpStatus.BAD_REQUEST);
		}
	}

}
