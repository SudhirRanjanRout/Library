package com.sudhir.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Book implements Serializable{
	
	@Id
	@Column(name = "CALLNO")
	private Long callNo;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@Column(name = "AUTHOR")
	private String bookAuthor;
	
	@Column(name = "PUBLISHER")
	private String bookPublisher;
	
	@Column(name = "QUANTITY")
	private int quanity;
	
	@Column(name = "ISSUED_BOOK")
	private int issuedBooks;
	
	 @ManyToOne
	    private Images images;

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


	public Images getImages() {
		return images;
	}


	public void setImages(Images images) {
		this.images = images;
	}
	}
