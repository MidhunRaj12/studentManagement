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
    
    @Column(name = "reg_no")
    private Long reg_no;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "course_id")
    private Long courseId;
    
	public long getId() {
		return id;
	}
	public Long getRegNo() {
		return reg_no;
	}
	public void setRegNo(Long reg_no) {
		this.reg_no = reg_no;
	}
	public String getStudentName() {
		return name;
	}
	public void setStudentName(String studentName) {
		this.name = studentName;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name +  ", courseId=" + courseId
				+ ", reg_no=" + reg_no +  "]";
	}
}
