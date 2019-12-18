package com.infosys.studentmanage.user.service;



import com.infosys.studentmanage.user.model.APIResponseModel;

public interface StudentService {

	APIResponseModel findStudentById(Long Id);
	APIResponseModel fetchAttendance(Long Id);

}
