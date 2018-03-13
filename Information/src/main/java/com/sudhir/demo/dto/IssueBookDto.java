package com.sudhir.demo.dto;

import java.util.Date;

public class IssueBookDto {
	private Long callNo;
	private String studentId;
	private String studentName;
	private String mobileNo;
	private Date issueddate;
	private String returnStatus;
	public Long getCallNo() {
		return callNo;
	}
	public void setCallNo(Long callNo) {
		this.callNo = callNo;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
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

}
