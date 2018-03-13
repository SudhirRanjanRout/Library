package com.sudhir.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.demo.domain.Book;
import com.sudhir.demo.dto.BookDto;
import com.sudhir.demo.service.BookService;

@RestController
@RequestMapping("/api/book")
@CrossOrigin()
public class BookController {
	
	@Autowired
	private BookService bookService;
	@PostMapping(value = "/addBook")
	public ResponseEntity<?> addBook(@RequestBody BookDto bookDto ){
		Map<String,Object> map = new HashMap<String,Object>();
		Book books = bookService.addBook(bookDto);
		map.put("book", books);
		return new ResponseEntity<>(map, HttpStatus.OK);

		}
	
	@GetMapping(path = "/getAllBooks")
	public ResponseEntity<?> gettAllBooks(){
		List<BookDto> bookDto = this.bookService.getAll();
		return new ResponseEntity<>(bookDto, HttpStatus.OK);
		
	}

}