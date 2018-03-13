package com.sudhir.demo.dto;

import javax.persistence.Column;

public class StudentDto {
	
private Long studentId;
	
	
	private String studentName;
	
	
	private String mobileNo;


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

}
