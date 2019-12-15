package com.infosys.studentmanage.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id")
    private long id;
    
    @Column(name = "RegNo")
    private long RegNo;
    
    @Column(name = "Name")
    private String studentName;
    
    @Column(name = "course_id")
    private long courseId;
    
	public long getId() {
		return id;
	}
	public long getRegNo() {
		return RegNo;
	}
	public void setRegNo(long regNo) {
		RegNo = regNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setId(long id) {
		this.id = id;
	}

	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

}
