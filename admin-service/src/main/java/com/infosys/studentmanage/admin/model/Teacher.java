package com.infosys.studentmanage.admin.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @Column(name = "Teacher_id")
    private long id;
    
    @Column(name = "teacher_name")
    private String teacherName;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "Teacher_id", referencedColumnName = "user_id")
     private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
    
    
}
