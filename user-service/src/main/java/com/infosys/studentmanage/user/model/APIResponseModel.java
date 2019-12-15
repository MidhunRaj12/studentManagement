package com.infosys.studentmanage.user.model;

import java.util.List;


public class APIResponseModel {
	
	private String responseCode;
	private String description;
	private User member;
	private AttendanceHistory bookIssueDetails;
	private List<AttendanceHistoryDTO> bookIssueDetailsList;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getMember() {
		return member;
	}
	public void setMember(User member) {
		this.member = member;
	}
	public AttendanceHistory getBookIssueDetails() {
		return bookIssueDetails;
	}
	public void setBookIssueDetails(AttendanceHistory bookIssueDetails) {
		this.bookIssueDetails = bookIssueDetails;
	}
	public List<AttendanceHistoryDTO> getBookIssueDetailsList() {
		return bookIssueDetailsList;
	}
	public void setBookIssueDetailsList(List<AttendanceHistoryDTO> bookIssueDetailsList) {
		this.bookIssueDetailsList = bookIssueDetailsList;
	}
	@Override
	public String toString() {
		return "APIResponseModel [responseCode=" + responseCode + ", description=" + description + ", member=" + member
				+ ", bookIssueDetails=" + bookIssueDetails + ", bookIssueDetailsList=" + bookIssueDetailsList + "]";
	}
	
	
	

}
