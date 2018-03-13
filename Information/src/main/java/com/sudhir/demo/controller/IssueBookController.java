package com.sudhir.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.demo.dto.IssueBookDto;
import com.sudhir.demo.service.BookService;
import com.sudhir.demo.service.IssueBookService;

@RestController

public class IssueBookController {
	
	@Autowired
	private IssueBookService bookService;
	
	@PostMapping(path = "/issueBook")
	public ResponseEntity<?> issueBook(@RequestBody IssueBookDto issueBookDto){
		return new ResponseEntity<>(this.bookService.issueBookToStudent(issueBookDto), HttpStatus.OK);
		
	}

}
