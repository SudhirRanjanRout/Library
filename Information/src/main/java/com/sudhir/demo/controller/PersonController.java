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
import org.springframework.web.bind.annotation.RestController;

import com.sudhir.demo.domain.Person;
import com.sudhir.demo.dto.LoginDto;
import com.sudhir.demo.dto.PersonDto;
import com.sudhir.demo.service.PersonService;


@RestController
@CrossOrigin()
public class PersonController {
	
	@Autowired
	private PersonService personService;
	


	
	@PostMapping(path = "/create")
		public ResponseEntity<?> createPerson(@RequestBody PersonDto personDto){
		String user = this.personService.createPerson(personDto);
		Map <String,Object> map = new HashMap<String,Object>();
		map.put("user", this.personService.findByEmail(personDto.getEmail()));
		return new ResponseEntity<>(map, HttpStatus.OK);
		//return ResponseEntity.ok().body(this.personService.createPerson(personDto));
	}
	@PostMapping(value = "/adminLogin")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
		Map <String,Object> map = new HashMap<String,Object>();
		String user = this.personService.login(loginDto);
		if(user != null && user != "password Mismatch"){
		//map.put("user",user);
		map.put("user",this.personService.findByEmail(loginDto.getEmail()));
		return new ResponseEntity<>(map, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping(path = "/getTotalPerson")
	public ResponseEntity<?> getPersonDetails(){
		List<PersonDto> personList = personService.getPersonDetails(); 
		return new ResponseEntity<>(personList,HttpStatus.OK);
		
	}
	public PersonService getPersonService() {
		return personService;
	}



	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
}
