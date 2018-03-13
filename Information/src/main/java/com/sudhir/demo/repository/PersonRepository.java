package com.sudhir.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudhir.demo.domain.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person,String> {
	
	public Person findByEmail(String email);

}
