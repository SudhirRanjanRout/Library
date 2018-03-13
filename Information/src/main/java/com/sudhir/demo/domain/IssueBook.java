package com.sudhir.demo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class IssueBook {
	
	@Id
	@Column(name = "CallNo")
	private Long callNo;
	@Column(name = "MOBILENO")
	private String mobileNo;
	@Column(name = "ISSUE_DATE") 
	@Temporal(TemporalType.TIMESTAMP)
	private Date issueddate;
	@Column(name = "STATUS")
	private String returnStatus;
	
	
	private String studentName;
	
	//@OneToMany
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	
	public Long getCallNo() {
		return callNo;
	}
	public void setCallNo(Long callNo) {
		this.callNo = callNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Date getIssueddate() {
		return issueddate;
	}
	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}
	public String getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	

}
