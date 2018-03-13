package com.sudhir.demo.service;

import java.util.List;

import com.sudhir.demo.domain.Person;
import com.sudhir.demo.dto.LoginDto;
import com.sudhir.demo.dto.PersonDto;

public interface PersonService {
	
	public String createPerson(PersonDto personDto);
	
	public String login(LoginDto loginDto);
	
	public Person findByEmail(String email);
	
	public List<PersonDto> getPersonDetails();
	//public void update(Person)

}
