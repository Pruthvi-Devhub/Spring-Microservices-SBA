package com.BookService.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookService.model.Book;
import com.BookService.repo.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController

public class BookController {

	@Autowired
	private BookRepository bookRepo;

	private static final Logger logobj = LoggerFactory.getLogger(BookController.class);

	@GetMapping("/bookService/getBookCost/bookname/{bookname}")
	public ResponseEntity<Book> getBookByName(@PathVariable String bookname) {
		try {
			Book book = bookRepo.findByBookName(bookname);
			if (book != null) {
				logobj.info("The book with name " + bookname + " is found and returned");
				return new ResponseEntity<Book>(book, HttpStatus.FOUND);

			}

		} catch (Exception e) {
			logobj.info("Exception occured " + e);

		}
		return new ResponseEntity(
				"No Book is present with name -" + bookname + ". Please enter the correct name and try again!",
				HttpStatus.NOT_FOUND);

	}

}
