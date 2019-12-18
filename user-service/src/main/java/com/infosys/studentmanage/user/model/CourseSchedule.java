package com.infosys.studentmanage.user.model;

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
    private Long id;
    
	@Column(name = "teacher_id")
    private Long teacher_id;
     
    @Column(name = "course_date")
    private Date course_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTeacherId() {
		return teacher_id;
	}

	public void setTeacherId(Long teacher_id) {
		this.teacher_id = teacher_id;
	}

	public Date getCourseDate() {
		return course_date;
	}

	public void setCourseDate(Date course_date) {
		this.course_date = course_date;
	}



	}