package com.infosys.studentmanage.teacher.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "attendance_history")
@Entity
public class AttendanceHistory {
	@Id
    @Column(name = "course_id")
    private long id;
    
	@Column(name = "student_id")
    private long studentId;
    
    @Column(name = "book_id")
    private Long bookId;
    
    @Column(name = "course_date")
    private Date courseDate;
    
    @Column(name = "attended")
    private boolean attended;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Date getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}

	public boolean isAttended() {
		return attended;
	}

	public void setAttended(boolean attended) {
		this.attended = attended;
	}
    
   
}
