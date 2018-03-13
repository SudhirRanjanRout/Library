package com.sudhir.demo.service;

import java.util.List;

import com.sudhir.demo.domain.Book;
import com.sudhir.demo.dto.BookDto;



public interface BookService {
	
	public Book addBook(BookDto bookDto);

	public List<BookDto> getAll(); 
	
	public Book findByCallNo(long callNo);
}
