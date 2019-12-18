package com.infosys.studentmanage.user.service;

import com.infosys.studentmanage.user.model.APIResponseModel;
import com.infosys.studentmanage.user.model.Attendance;
import com.infosys.studentmanage.user.model.User;

public interface TeacherService {
	
	APIResponseModel fetchCourseSchedule(long Id);
	APIResponseModel fetchStudentDetails(Long Id);
	APIResponseModel findTeacerById(Long Id);
	APIResponseModel markAttendance(Attendance attendance);

}
