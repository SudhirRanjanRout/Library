package com.sudhir.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudhir.demo.domain.IssueBook;

public interface IssueBookRepository extends JpaRepository<IssueBook, Long> {

}
