package com.infosys.studentmanage.admin.service;

import java.util.List;

import com.infosys.studentmanage.admin.model.APIResponseModel;
import com.infosys.studentmanage.admin.model.Student;
import com.infosys.studentmanage.admin.model.Teacher;

public interface AdminService {
	
	APIResponseModel save(Student student);
	APIResponseModel updateRegno(long Id);
	APIResponseModel updateCourse(long Id);
	APIResponseModel findById(long Id);
	APIResponseModel delete(long Id);
    APIResponseModel findByTeacherId(long teacherId);

    APIResponseModel findAllTeachers();
    APIResponseModel findAllStudents();

}
