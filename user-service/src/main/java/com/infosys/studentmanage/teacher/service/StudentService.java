package com.infosys.studentmanage.teacher.service;



import com.infosys.studentmanage.teacher.model.APIResponseModel;
import com.infosys.studentmanage.teacher.model.AttendanceHistory;

public interface StudentService {

	APIResponseModel fetchStudentDetails(Long Id, String oauthHeader);
	APIResponseModel fetchCourseAssigned(Long Id, String oauthHeader);
	APIResponseModel fetchAttendance(Long Id, String oauthHeader);
	

}
