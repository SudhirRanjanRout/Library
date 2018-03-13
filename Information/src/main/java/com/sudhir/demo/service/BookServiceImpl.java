package com.sudhir.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhir.demo.domain.Book;
import com.sudhir.demo.dto.BookDto;
import com.sudhir.demo.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book addBook(BookDto bookDto) {
		// TODO Auto-generated method stub
		if(bookDto != null) {
			Book book = new Book();
			BeanUtils.copyProperties(bookDto, book);
			book.setIssuedBooks(0);
			bookRepository.save(book);
			
		}
		return null;
	}

	@Override
	public List<BookDto> getAll() {
		// TODO Auto-generated method stub
		List<Book> book = bookRepository.findAll();
		List<BookDto> bookDtoList = new ArrayList<BookDto>();
		if(book !=  null) {
			for(Book books: book) {
				BookDto bookDto = new BookDto();
				BeanUtils.copyProperties(books, bookDto);
				bookDtoList.add(bookDto);
			}
			bookDtoList.forEach(a->{
				
			});
			if(bookDtoList == null) {
				System.out.println( "no books is found in system");
			}else {
				return bookDtoList;
			}
		}
		return null;
	}

	@Override
	public Book findByCallNo(long callNo) {
		// TODO Auto-generated method stub
		return bookRepository.findByCallNo(callNo);
	}

}
