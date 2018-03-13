package com.sudhir.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sudhir.demo.domain.Person;
import com.sudhir.demo.dto.LoginDto;
import com.sudhir.demo.dto.PersonDto;
import com.sudhir.demo.repository.PersonRepository;
@Service
@Repository
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public String createPerson(PersonDto personDto) {
		// TODO Auto-generated method stub
		Person person = new Person();
		BeanUtils.copyProperties(personDto, person);
		if(person != null){
			//person.setId((long) 1);
		personRepository.save(person);
		return "Person saved successfully";
		}
		return null;
	}

	/*@Override
	public String login(LoginDto loginDto) {
		// TODO Auto-generated method stub
		String email = loginDto.getEmail();
		String password = loginDto.getPassword();
		Person person = personRepository.findByEmail(email);
		if(person != null){
		if(password.equals(person.getPassword())){
			return "Login SUccessful";
		}else{
			return "password not matched";
		}
		}return null;
	}*/

	@Override
	public Person findByEmail(String email) {
		// TODO Auto-generated method stub
		
		return personRepository.findByEmail(email);
	}

	@Override
	public String login(LoginDto loginDto) {
		// TODO Auto-generated method stub
		String email = loginDto.getEmail();
		if(loginDto != null){
		Person person = personRepository.findByEmail(email);
			if(person != null){
				if(loginDto.getPassword().equals(person.getPassword())){
					return "Login Successful";
				}else{
					return "password Mismatch";
				}
			}
		}else{
			return "email does not match ";
		}
		
		return null;
	}

	@Override
	public List<PersonDto> getPersonDetails() {
		// TODO Auto-generated method stub
		List<Person> personList = personRepository.findAll();
		List<PersonDto> personDtoList = new ArrayList();
		
		System.out.println("Total no of count:"+personList);
		for(Person persons: personList){
			System.out.println("total no of list is------->"+persons);
			System.out.println("name is:"+persons.getFirstName());
			System.out.println("total:"+persons.toString());
			PersonDto personDto = new PersonDto();
			BeanUtils.copyProperties(persons, personDto);
			personDtoList.add(personDto);
		}
		personDtoList.forEach((a)->{
			
		});
		if(personDtoList == null){
			System.out.println("no user exist in the system");
		}
		
		return personDtoList;
		
	}
	
	

}
