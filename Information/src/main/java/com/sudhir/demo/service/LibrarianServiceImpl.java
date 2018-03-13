package com.sudhir.demo.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhir.demo.domain.Librarian;
import com.sudhir.demo.dto.LibrarianDto;
import com.sudhir.demo.dto.LibrarianLoginDto;
import com.sudhir.demo.dto.LoginDto;
import com.sudhir.demo.repository.LibrarianRepository;
@Service
public class LibrarianServiceImpl implements LibrarianService {
	
	@Autowired
	private LibrarianRepository librarianRepository;

	@Override
	public String addLibrarian(LibrarianDto librarianDto) {
		// TODO Auto-generated method stub
		Librarian librarian = new Librarian();
		if(librarianDto != null){
			librarianDto.setStatus(true);
			BeanUtils.copyProperties(librarianDto, librarian);
			librarianRepository.save(librarian);
			return"librian has been added successfully";
		}/*else{
			return "seems having some problem to add this,please provide with valid data";
		}*/
		return null;
	}

	@Override
	public List<LibrarianDto> getAll() {
		// TODO Auto-generated method stub
		List<Librarian> librarian = librarianRepository.findAll();
		List<LibrarianDto> librarianDtoList = new ArrayList<>();
		if(librarian != null){
			//BeanUtils.copyProperties(librarian, librarianDto);
			for (Librarian librarians: librarian){
				System.out.println("total is:"+librarians);
				LibrarianDto librarianDto = new LibrarianDto();
				BeanUtils.copyProperties(librarians, librarianDto);
				librarianDtoList.add(librarianDto);
			}
			librarianDtoList.forEach((a)->{
				
			});
			if(librarianDtoList == null){
				System.out.println( "no librarian is found in system");
			}else{
				return librarianDtoList;
			}
		}
		return null;
	}

	@Override
	public String findByEmail(String email) {
		// TODO Auto-generated method stub
		 this.librarianRepository.findByEmail(email);
		return null;
	}

	@Override
	public LibrarianDto updateLibrarian(LibrarianDto librarianDto, Librarian librarian) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(librarianDto, librarian);
		librarianRepository.save(librarian);
		return null;
	}

	@Override
	public Librarian findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return this.librarianRepository.findByFirstName(firstName);
	
	}

	@Override
	public Librarian getLibrarianById(long userId) {
		// TODO Auto-generated method stub
		Librarian librarian = librarianRepository.findOne(userId);
		if (librarian==null)
			System.out.println("User doesn't exist");
		return librarian;
	}

	@Override
	public String login(LibrarianLoginDto loginDto) {
		// TODO Auto-generated method stub
		Librarian librarian = librarianRepository.findByEmail(loginDto.getEmail());
		if(librarian != null) {
			
		if(loginDto.getPassword().equals(librarian.getPassWord())) {
			return "login successful";
		}else {
			return "password mismatch";
		}
		}return null;
	}

	@Override
	public String login(LoginDto loginDto) {
		// TODO Auto-generated method stub
		Librarian librarian = librarianRepository.findByEmail(loginDto.getEmail());
		if(librarian != null) {
			
			if(loginDto.getPassword().equals(librarian.getPassWord())) {
				return "login successful";
			}else {
				return "password mismatch";
			}
			}
		return null;
	}

}
