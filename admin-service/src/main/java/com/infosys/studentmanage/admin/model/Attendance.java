package com.infosys.studentmanage.admin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attendance")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "course_id")
    private Long course_id;
    @Column(name = "student_id")
    private Long student_id;
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
