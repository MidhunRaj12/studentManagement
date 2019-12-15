package com.infosys.studentmanage.user.service;



import com.infosys.studentmanage.user.model.APIResponseModel;
import com.infosys.studentmanage.user.model.AttendanceHistory;

public interface StudentService {

	APIResponseModel fetchStudentDetails(Long Id, String oauthHeader);
	APIResponseModel fetchCourseAssigned(Long Id, String oauthHeader);
	APIResponseModel fetchAttendance(Long Id, String oauthHeader);
	

}
