package com.infosys.studentmanage.admin.service;

import java.util.List;

import com.infosys.studentmanage.admin.model.APIResponseModel;
import com.infosys.studentmanage.admin.model.Student;
import com.infosys.studentmanage.admin.model.Teacher;

public interface AdminService {
	
	APIResponseModel save(Student student);
	APIResponseModel update(Long regNo);
	void updateStatus(Student student);
	APIResponseModel findById(long RegNo);
	APIResponseModel delete(long id);
    APIResponseModel findByTeacherId(long teacherId);

	
	 List<Student> findAllStudents(List<Long> ids); 
	 List<Teacher> findAllTeachers(List<Long> ids);
	
    List<Teacher> findAllTeachers();
    List<Student> findAllStudents();

}
