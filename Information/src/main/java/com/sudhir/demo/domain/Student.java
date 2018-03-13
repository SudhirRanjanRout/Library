package com.sudhir.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Student {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	@Column(name = "mobileNo")
	private String mobileNo;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy ="student")
	private List<IssueBook> issueBook;/* = new ArrayList<IssueBook>();*/
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public List<IssueBook> getIssueBook() {
		return issueBook;
	}
	public void setIssueBook(List<IssueBook> issueBook) {
		this.issueBook = issueBook;
	}

}
