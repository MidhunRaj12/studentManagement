package com.infosys.studentmanage.teacher.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "course_schedule")
@Entity
public class CourseSchedule {
	@Id
    @Column(name = "course_id")
    private long id;
    
	@Column(name = "teacher_id")
    private long teacherId;
     
    @Column(name = "course_date")
    private Date courseDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public Date getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}
    

	}