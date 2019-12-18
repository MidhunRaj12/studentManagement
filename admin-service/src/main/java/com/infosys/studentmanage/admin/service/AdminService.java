package com.infosys.studentmanage.admin.service;

import java.util.List;

import com.infosys.studentmanage.admin.model.APIResponseModel;
import com.infosys.studentmanage.admin.model.Attendance;
import com.infosys.studentmanage.admin.model.Student;
import com.infosys.studentmanage.admin.model.Teacher;

public interface AdminService {
	
	APIResponseModel saveStudent(Student student);
	APIResponseModel saveTeacher(Teacher teacher);

	APIResponseModel updateStudent(Student student);
	APIResponseModel updateTeacher(Teacher teacher);

	APIResponseModel findById(long Id);
	APIResponseModel delete(long Id);
    APIResponseModel findByTeacherId(long teacherId);

    APIResponseModel findAllTeachers();
    APIResponseModel findAllStudents();
    APIResponseModel getReport();
    
    void markAttendance(Attendance attendance);

}
