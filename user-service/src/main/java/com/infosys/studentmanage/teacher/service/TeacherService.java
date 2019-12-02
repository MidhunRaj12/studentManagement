package com.infosys.studentmanage.teacher.service;

import com.infosys.studentmanage.teacher.model.APIResponseModel;
import com.infosys.studentmanage.teacher.model.User;

public interface TeacherService {
	
	APIResponseModel fetchCourseSchedule(Long Id, String oauthHeader);
	APIResponseModel fetchStudentDetails(Long Id, String oauthHeader);
	APIResponseModel MarkAttendance(Long Id, String oauthHeader);

}
