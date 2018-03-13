package com.sudhir.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.demo.domain.Librarian;
import com.sudhir.demo.dto.LibrarianDto;
import com.sudhir.demo.dto.LibrarianLoginDto;
import com.sudhir.demo.dto.LoginDto;
import com.sudhir.demo.service.LibrarianService;

@RestController
@CrossOrigin()
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/librarian")
public class LibrarianController {
		//String abc = null;
	@Autowired
	private LibrarianService librarianService;

	public LibrarianService getLibrarianService() {
		return librarianService;
	}

	public void setLibrarianService(LibrarianService librarianService) {
		this.librarianService = librarianService;
	}
	
	@PostMapping(path ="/addLibrarian")
	public ResponseEntity<?> addLibrarian(@RequestBody LibrarianDto librarianDto){
		//String newLibrarian = this.librarianService.addLibrarian(librarianDto);
		Map<String,Object> map = new HashMap<String,Object>();
		String s1 = new String("aaa");
		String abc = null;
		//map.put("newLibrarian", newLibrarian);
		//return new ResponseEntity<>(map,HttpStatus.OK);
		return  new ResponseEntity<>(this.librarianService.addLibrarian(librarianDto), HttpStatus.OK);
	}
	@GetMapping(path="/getAllLibrarian")
	public ResponseEntity<?> getAllLibrarian(){
		List<LibrarianDto> librarianDto = librarianService.getAll();
		
		return new ResponseEntity<>(librarianDto, HttpStatus.OK);
	}
	
	@PutMapping(path = "/updateLibrarian")
	public ResponseEntity<?> updateLibrarian(@RequestBody LibrarianDto librarianDto){
		//Librarian librarianName = librarianService.findByEmail(librarianDto.getEmail());
		String librarianName = librarianDto.getFirstName();
		Librarian librarian = librarianService.findByFirstName(librarianName);
		if (librarian == null){
			System.out.println("no librarian exist in system");
		}else
		this.librarianService.updateLibrarian(librarianDto, librarian);
		//return new ResponseEntity<> (HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping( value ="/{userId}", produces = "application/json")
	public ResponseEntity<?> getLibrarianProfile(@PathVariable("userId") long userId){
		
		Librarian librarianName = librarianService.getLibrarianById(userId);
		LibrarianDto librarianDto = new LibrarianDto();
		BeanUtils.copyProperties(librarianName, librarianDto);
		return new ResponseEntity<>(librarianDto,HttpStatus.OK);
	}
	
	@PostMapping(path = "/librarianLogin")
	public ResponseEntity<?> login(@RequestBody LibrarianLoginDto loginDto){
		Map<String,Object> map = new HashMap<String,Object>();
		String librarian = this.librarianService.login(loginDto);
		if(librarian != null ) {
			map.put("librarian", this.librarianService.findByEmail(loginDto.getEmail()));
			return new ResponseEntity<>(map, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	/*@PostMapping(path = "/librarianLogin")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
		return new ResponseEntity<>(this.librarianService.login(loginDto), HttpStatus.OK);
	}*/
	
}
