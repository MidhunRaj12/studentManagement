package com.infosys.studentmanage.user.model;

import java.sql.Date;



public class AttendanceHistoryDTO {
	

    private long id;
    private long student_Id;
    private Date courseDate;
    private boolean attended;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStudentId() {
		return student_Id;
	}

	public void setStudentId(long student_Id) {
		this.student_Id = student_Id;
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