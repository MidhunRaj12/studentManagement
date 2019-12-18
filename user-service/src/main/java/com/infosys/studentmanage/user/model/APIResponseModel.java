package com.infosys.studentmanage.user.model;

import java.util.List;


public class APIResponseModel {
	
	private String responseCode;
	private String description;
	private Student student;
	private Teacher teacher;
	private Attendance attendance;
	private List<Attendance> attendanceList;
	private List<CourseSchedule> courseSchedule;
	
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public List<CourseSchedule> getCourseSchedule() {
		return courseSchedule;
	}

	public void setCourseSchedule(List<CourseSchedule> courseSchedule) {
		this.courseSchedule = courseSchedule;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public List<Attendance> getAttendanceList() {
		return attendanceList;
	}

	public void setAttendanceList(List<Attendance> attendanceList) {
		this.attendanceList = attendanceList;
	}

	@Override
	public String toString() {
		return "APIResponseModel [responseCode=" + responseCode + ", description=" + description + ", student=" + student
				+ ", attendance=" + attendance + ", attendanceList=" + attendanceList + "]";
	}
	
	
	

}
