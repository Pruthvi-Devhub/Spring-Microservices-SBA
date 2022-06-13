package com.BookService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookService.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
	public Book findByBookName(String bookName);

}
