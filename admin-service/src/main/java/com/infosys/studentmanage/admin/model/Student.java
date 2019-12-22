package com.infosys.studentmanage.admin.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;import com.fasterxml.jackson.core.sym.Name;


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
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "student_id", referencedColumnName = "user_id")
     private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getReg_no() {
		return reg_no;
	}

	public void setReg_no(Long reg_no) {
		this.reg_no = reg_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
 
    
}