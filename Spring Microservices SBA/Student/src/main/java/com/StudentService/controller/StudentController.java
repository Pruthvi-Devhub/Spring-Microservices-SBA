package com.StudentService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentService.Proxy.BookProxy;
import com.StudentService.model.BookDTO;

@RestController
@RequestMapping("/studentService")

public class StudentController {

	private static final Logger logobj = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private BookProxy proxy;



	@GetMapping("/findCost/bookname/{bookname}/quantity/{quantity}")
	public ResponseEntity<BookDTO> findCostByBookDetails(@PathVariable String bookname,
			@PathVariable Integer quantity) {
		BookDTO book = proxy.getBookByName(bookname);
		if (bookname.isEmpty()) {
			logobj.error(bookname + " book name entered is empty");
			return new ResponseEntity("book name entered is empty", HttpStatus.NOT_FOUND);
		}
		if (book == null) {
			logobj.info("Book with name " + bookname + " is not found");
			return new ResponseEntity(
					"No Book is present with name -" + bookname + ". Please enter the correct name and try again!",
					HttpStatus.NOT_FOUND);
		}

		BookDTO b = new BookDTO(book.getBookId(), book.getBookName(), book.getBookCost(), quantity,
				(book.getBookCost() * quantity));

		logobj.info(b.toString() + " found with details");

		return new ResponseEntity<BookDTO>(b, HttpStatus.FOUND);

	}
}
