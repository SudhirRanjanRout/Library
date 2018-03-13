package com.sudhir.demo.dto;

import javax.persistence.Column;

public class BookDto {
	
	private Long callNo;
	
	private String bookName;
	
	private String bookAuthor;
	
	private String bookPublisher;
	
	private int quanity;
	
	private int issuedBooks;

	public Long getCallNo() {
		return callNo;
	}

	public void setCallNo(Long callNo) {
		this.callNo = callNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public int getIssuedBooks() {
		return issuedBooks;
	}

	public void setIssuedBooks(int issuedBooks) {
		this.issuedBooks = issuedBooks;
	}

	

}
