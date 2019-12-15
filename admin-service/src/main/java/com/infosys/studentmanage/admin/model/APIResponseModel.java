package com.infosys.studentmanage.admin.model;

import java.util.List;

public class APIResponseModel {
	
	private String responseCode;
	private String description;
	private Student student;
	private Teacher teacher;
	private List<Student> students;
	private List<Teacher> teachers;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getDescription() {
		return description;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
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
