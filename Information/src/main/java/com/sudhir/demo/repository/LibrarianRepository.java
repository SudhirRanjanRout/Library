package com.sudhir.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudhir.demo.domain.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Long> {
	
	public Librarian findByEmail(String email);
	
	public Librarian findByFirstName(String firstName);

	public Librarian findOne(Long id);

}
