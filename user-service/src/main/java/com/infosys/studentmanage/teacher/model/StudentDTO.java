package com.infosys.studentmanage.teacher.model;

public class StudentDTO {

	private long id;
	private String studentName;
	private CourseSchedule category;
	private String status;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setBookName(String studentName) {
		this.studentName = studentName;
	}
	public CourseSchedule getCategory() {
		return category;
	}
	public void setCategory(CourseSchedule category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", studentName=" + studentName + ", category=" + category + ", status=" + status + "]";
	}



}



