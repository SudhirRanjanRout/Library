package com.sudhir.demo.service;

import java.util.List;

import com.sudhir.demo.domain.Librarian;
import com.sudhir.demo.dto.LibrarianDto;
import com.sudhir.demo.dto.LibrarianLoginDto;
import com.sudhir.demo.dto.LoginDto;

public interface LibrarianService {

	public String addLibrarian(LibrarianDto librarianDto);
	
	public List<LibrarianDto> getAll();
	
	public String findByEmail(String email);
	
	public LibrarianDto updateLibrarian(LibrarianDto librarianDto,Librarian librarian);
	
	public Librarian findByFirstName(String firstName);
	
	public Librarian getLibrarianById(long userId);
	
	public String login(LibrarianLoginDto loginDto);
	
	public String login(LoginDto loginDto);
	
	
}
