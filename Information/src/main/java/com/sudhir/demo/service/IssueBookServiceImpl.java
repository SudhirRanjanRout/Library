package com.sudhir.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhir.demo.domain.Book;
import com.sudhir.demo.domain.IssueBook;
import com.sudhir.demo.dto.IssueBookDto;
import com.sudhir.demo.repository.BookRepository;
@Service
public class IssueBookServiceImpl implements IssueBookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public int issueBookToStudent(IssueBookDto issueBookDto) {
		// TODO Auto-generated method stub
		Long callNo = issueBookDto.getCallNo();
		boolean checkStatus = checkIssue(callNo);
		System.out.println("Check Status:"+checkStatus);
		if(checkStatus) {
			int status = 0;
			try {
				IssueBook issueBook = new IssueBook();
				BeanUtils.copyProperties(issueBookDto, issueBook);
				
			}catch(Exception e) {
				
			}
			
		}
		
		return 0;
	}
	
	 private boolean checkIssue(Long callNo) {
		 boolean status = false;
		 try {
			 Book book = bookRepository.findByCallNo(callNo);
			 int quantity = book.getQuanity();
			 if(quantity > 0) {
				 //IssueBook issueBook = 
				 status = true;
			 }else {
				 status = false;
			 }
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return status;
		
	}

}
