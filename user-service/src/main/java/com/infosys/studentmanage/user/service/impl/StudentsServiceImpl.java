package com.infosys.studentmanage.user.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.infosys.studentmanage.user.constants.MemberServiceConstants;
import com.infosys.studentmanage.user.kafka.EventSender;
import com.infosys.studentmanage.user.model.APIResponseModel;
import com.infosys.studentmanage.user.model.Attendance;
import com.infosys.studentmanage.user.model.AttendanceHistoryDTO;
import com.infosys.studentmanage.user.model.Student;
import com.infosys.studentmanage.user.repository.AttendanceRepo;
import com.infosys.studentmanage.user.repository.StudentRepo;
import com.infosys.studentmanage.user.repository.TeacherRepo;
import com.infosys.studentmanage.user.service.StudentService;
import com.infosys.studentmanage.user.service.TeacherService;
import com.infosys.studentmanage.user.utils.AttendanceUtils;

@Service
public class StudentsServiceImpl implements StudentService{

	@Autowired
	AttendanceRepo attendanceRepo;
	@Autowired
	StudentRepo StudentRepository;

	
	@Autowired
	TeacherService teacherService;

	@Autowired
	AttendanceUtils utils;


	
	@Override
	public APIResponseModel findStudentById(Long Id) {

		APIResponseModel response = null;
		try {
			Student student = StudentRepository.findById(Id).get();
			response = utils.getResponseModel(MemberServiceConstants.CODE_SUCCESS,
					MemberServiceConstants.MESSAGE_SUCCESS, student);
		} catch (Exception e) {
			response = utils.getResponseModel(MemberServiceConstants.CODE_EXCEPTION,
					MemberServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}
	@Override
	public APIResponseModel fetchAttendance(Long Id) {
		APIResponseModel response = null;
		try
		{
			List<Attendance> attendanceList = attendanceRepo.findByStudentId(Id);
			response = utils.getResponseModel(MemberServiceConstants.CODE_SUCCESS, 
					MemberServiceConstants.MESSAGE_SUCCESS, attendanceList);
		}
		catch(Exception e)
		{
			response = utils.getResponseModel(MemberServiceConstants.CODE_EXCEPTION, 
					MemberServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}


}
