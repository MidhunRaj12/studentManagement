package com.infosys.studentmanage.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.infosys.studentmanage.user.model.Teacher;
import com.infosys.studentmanage.user.constants.MemberServiceConstants;
import com.infosys.studentmanage.user.kafka.EventSender;
import com.infosys.studentmanage.user.model.APIResponseModel;
import com.infosys.studentmanage.user.model.Attendance;
import com.infosys.studentmanage.user.model.CourseSchedule;
import com.infosys.studentmanage.user.model.Student;
import com.infosys.studentmanage.user.repository.AttendanceRepo;
import com.infosys.studentmanage.user.repository.ScheduleRepo;
import com.infosys.studentmanage.user.repository.StudentRepo;
import com.infosys.studentmanage.user.repository.TeacherRepo;
import com.infosys.studentmanage.user.service.TeacherService;
import com.infosys.studentmanage.user.utils.AttendanceUtils;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	ScheduleRepo scheduleRepo;
	
	@Autowired
	StudentRepo StudentRepository;
	
	@Autowired
	TeacherRepo teacherRepository;
	
	@Autowired
	AttendanceRepo attendanceRepo;
	
	@Autowired
	EventSender eventSender;
	
	@Autowired
	AttendanceUtils utils;
	
	@Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
	
	@Override
	public APIResponseModel fetchCourseSchedule(Long Id) {
		APIResponseModel response = null;
		try
		{
			List<CourseSchedule> courseScheduleList = scheduleRepo.findByTeacherId(Id);
			response = utils.getResponseModel(MemberServiceConstants.CODE_SUCCESS, courseScheduleList, 
					MemberServiceConstants.MESSAGE_SUCCESS);
		}
		catch(Exception e)
		{
			response = utils.getResponseModel(MemberServiceConstants.CODE_EXCEPTION, 
					MemberServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}

	@Override
	public APIResponseModel fetchStudentDetails(Long Id) {

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
	public APIResponseModel findTeacerById(Long teacher_Id) {
		APIResponseModel response = null;
		try {
			Teacher teacher = teacherRepository.findById(teacher_Id).get();
			response = utils.getResponseModel(MemberServiceConstants.CODE_SUCCESS,
					MemberServiceConstants.MESSAGE_SUCCESS, teacher);
		} catch (Exception e) {
			response = utils.getResponseModel(MemberServiceConstants.CODE_EXCEPTION,
					MemberServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}
//	@Override
//	public User findById(Long id) {
//		return userRepository.findById(id).get();
//	}
	
	
	@Override
	public APIResponseModel markAttendance(Attendance attendance) {
		APIResponseModel response = null;
		try
		{
			if(StringUtils.isEmpty(attendance.getCourse_id()) || StringUtils.isEmpty(attendance.getStudent_id()) ||StringUtils.isEmpty(attendance.getCourse_time()))
			{
				response = utils.getResponseModel(MemberServiceConstants.CODE_INVALID_INPUT, 
						MemberServiceConstants.MESSAGE_INVALID_INPUT);
			}
			else
			{
				Attendance daoObject = attendanceRepo.findById(attendance.getStudent_id()).get();	
				if(daoObject.getAttended() == true || daoObject.getAttended() == false ){
					try {
						eventSender.send(attendance);
					} catch(Exception e)
					{
						response = utils.getResponseModel(MemberServiceConstants.CODE_KAFKA_ERROR, 
								MemberServiceConstants.MESSAGE_KAFKA_ERROR + e.getMessage());
					}
				}
			}

		}
		catch(Exception e)
		{
			response = utils.getResponseModel(MemberServiceConstants.CODE_EXCEPTION, 
					MemberServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}

		return response;
	}

}

