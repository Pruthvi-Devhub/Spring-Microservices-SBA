package com.StudentService.Proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.StudentService.model.BookDTO;



@FeignClient(name="book" )
public interface BookProxy {
    
    @GetMapping("bookService/getBookCost/bookname/{bookname}")
    public BookDTO getBookByName(@PathVariable String bookname);

 

}