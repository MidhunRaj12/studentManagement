package com.infosys.studentmanage.admin.model;

public class APIResponseModel {
	
	private String responseCode;
	private String description;
	private Student student;
	private Teacher teacher;
	
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	@Override
	public String toString() {
		return "APIResponseModel [responseCode=" + responseCode + ", description=" + description + ", student=" + student
				+ ", studentList=" + teacher + "]";
	}


}
