package com.infosys.studentmanage.admin.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAttendance")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "course_id")
    private long courseId;
    @Column(name = "RegNo")
    private String RegNo;
    @Column(name = "course_time")
    private Date courseTime;
    @Column(name = "attended")
    private boolean attended;
    
	public long getCategoryId() {
		return courseId;
	}
	public Date getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(Date courseTime) {
		this.courseTime = courseTime;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getRegNumber() {
		return RegNo;
	}
	public void setRegNumber(String RegNo) {
		this.RegNo = RegNo;
	}
	public boolean isAttended() {
		return attended;
	}
	public void setAttended(boolean attended) {
		this.attended = attended;
	}

}
