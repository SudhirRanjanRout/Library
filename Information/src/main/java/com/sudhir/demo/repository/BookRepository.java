package com.sudhir.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sudhir.demo.domain.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, String> {
	
	public Book findByCallNo(Long callNo);

}
