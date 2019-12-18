package com.infosys.studentmanage.user.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="attendance")
public class Attendance implements Serializable {
	
	@Id
    @Column(name = "course_id")
    private Long course_id;
	
	@Id
    @Column(name = "student_id")
    private Long student_id;
	
	@Id
    @Column(name = "course_time")
    private Date course_time;
	
    @Column(name = "attended")
    private Boolean attended;
	public Long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	public Date getCourse_time() {
		return course_time;
	}
	public void setCourse_time(Date course_time) {
		this.course_time = course_time;
	}
	public Boolean getAttended() {
		return attended;
	}
	public void setAttended(Boolean attended) {
		this.attended = attended;
	}
    
	@Override
	public String toString() {
		return "Student [id=" + course_id + ", student_id=" + student_id +  ", course_time=" + course_time
				+ ", attended=" + attended +  "]";
	}
}
