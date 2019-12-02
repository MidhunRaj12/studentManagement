package com.infosys.studentmanage.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "RegNo")
    private long id;
    
    @Column(name = "student_name")
    private String studentName;
    
    @Column(name = "course_id")
    private long courseId;
    
	/*
	 * @Column(name = "status") private String status;
	 */
    
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return studentName;
	}
	public void setName(String studentName) {
		this.studentName = studentName;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	/*
	 * public String getStatus() { return status; } public void setStatus(String
	 * status) { this.status = status; }
	 */

    
}
