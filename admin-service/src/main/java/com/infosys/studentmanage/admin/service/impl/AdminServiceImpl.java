package com.infosys.studentmanage.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.infosys.studentmanage.admin.constants.AdminServiceConstants;
import com.infosys.studentmanage.admin.model.APIResponseModel;
import com.infosys.studentmanage.admin.model.Attendance;
import com.infosys.studentmanage.admin.model.Student;
import com.infosys.studentmanage.admin.model.Teacher;
import com.infosys.studentmanage.admin.repository.AttendanceRepo;
import com.infosys.studentmanage.admin.repository.StudentRepo;
import com.infosys.studentmanage.admin.repository.TeacherRepo;
import com.infosys.studentmanage.admin.service.AdminService;
import com.infosys.studentmanage.admin.utils.AdminServiceUtils;

@Service
public class AdminServiceImpl implements AdminService {


	@Autowired
	StudentRepo StudentRepository;
	  
	@Autowired
	TeacherRepo TeacherRepository;
	
	@Autowired
	AttendanceRepo AttendanceRepository;
	
	@Autowired
	AdminServiceUtils utils;

	@Override
	public APIResponseModel saveStudent(Student student) {
		APIResponseModel response = null;
		try {
			if (StringUtils.isEmpty(student.getStudentName())) {
				response = utils.getResponseModel(AdminServiceConstants.CODE_INVALID_INPUT,
						AdminServiceConstants.MESSAGE_INVALID_INPUT);
				/*
//				 * } else if (StringUtils.isEmpty(student.getStatus()) ||
//				 * !AdminServiceConstants.AVAILABLE.equals(student.getStatus())) { response =
//				 * utils.getResponseModel(AdminServiceConstants.CODE_INVALID_STATUS,
//				 * AdminServiceConstants.MESSAGE_INVALID_STATUS);
//				 */
			} else {
				StudentRepository.save(student);
				response = utils.getResponseModel(AdminServiceConstants.CODE_SUCCESS,
						AdminServiceConstants.MESSAGE_SUCCESS, student);
			}
		} catch (Exception e) {
			response = utils.getResponseModel(AdminServiceConstants.CODE_EXCEPTION,
					AdminServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}

		return response;
	}
	
	public APIResponseModel saveTeacher(Teacher teacher) {
		APIResponseModel response = null;
		try {
			if (StringUtils.isEmpty(teacher.getTeacherName())) {
				response = utils.getResponseModel(AdminServiceConstants.CODE_INVALID_INPUT,
						AdminServiceConstants.MESSAGE_INVALID_INPUT);
				/*
//				 * } else if (StringUtils.isEmpty(student.getStatus()) ||
//				 * !AdminServiceConstants.AVAILABLE.equals(student.getStatus())) { response =
//				 * utils.getResponseModel(AdminServiceConstants.CODE_INVALID_STATUS,
//				 * AdminServiceConstants.MESSAGE_INVALID_STATUS);
//				 */
			} else {
				TeacherRepository.save(teacher);
				response = utils.getResponseModel(AdminServiceConstants.CODE_SUCCESS,
						AdminServiceConstants.MESSAGE_SUCCESS, teacher);
			}
		} catch (Exception e) {
			response = utils.getResponseModel(AdminServiceConstants.CODE_EXCEPTION,
					AdminServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}

		return response;
	}

	
	public APIResponseModel updateStudent(Student student) {
		APIResponseModel response = null;
		try
		{
			if(StringUtils.isEmpty(student.getCourseId()) || StringUtils.isEmpty(student.getRegNo()))
			{
				response = utils.getResponseModel(AdminServiceConstants.CODE_INVALID_INPUT, 
						AdminServiceConstants.MESSAGE_INVALID_INPUT);
			}
			else if(StringUtils.isEmpty(student.getId()))
			{
				response = utils.getResponseModel(AdminServiceConstants.CODE_INVALID_ID, 
						AdminServiceConstants.MESSAGE_INVALID_ID);
			}
			else
			{
				Student studentToUpdate = StudentRepository.findById(student.getId()).get();
				studentToUpdate.setCourseId(student.getCourseId());
				studentToUpdate.setRegNo(student.getRegNo());
				studentToUpdate.setStudentName(student.getStudentName());
				StudentRepository.save(studentToUpdate);
				response = utils.getResponseModel(AdminServiceConstants.CODE_SUCCESS, 
						AdminServiceConstants.MESSAGE_SUCCESS, student);
			}
		}
		catch(Exception e)
		{
			response = utils.getResponseModel(AdminServiceConstants.CODE_EXCEPTION, 
					AdminServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}

	
	public APIResponseModel updateTeacher(Teacher teacher) {
		APIResponseModel response = null;
		try
		{
			if(StringUtils.isEmpty(teacher.getId()))
			{
				response = utils.getResponseModel(AdminServiceConstants.CODE_INVALID_ID, 
						AdminServiceConstants.MESSAGE_INVALID_ID);
			}
			else
			{
				Teacher teacherToUpdate = TeacherRepository.findById(teacher.getId()).get();
				teacherToUpdate.setTeacherName(teacher.getTeacherName());
				TeacherRepository.save(teacherToUpdate);
				response = utils.getResponseModel(AdminServiceConstants.CODE_SUCCESS, 
						AdminServiceConstants.MESSAGE_SUCCESS, teacher);
			}
		}
		catch(Exception e)
		{
			response = utils.getResponseModel(AdminServiceConstants.CODE_EXCEPTION, 
					AdminServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}

	@Override
	public APIResponseModel findById(long id) {
		APIResponseModel response = null;
		try {
			Student student = StudentRepository.findById(id).get();
			response = utils.getResponseModel(AdminServiceConstants.CODE_SUCCESS,
					AdminServiceConstants.MESSAGE_SUCCESS, student);
		} catch (Exception e) {
			response = utils.getResponseModel(AdminServiceConstants.CODE_EXCEPTION,
					AdminServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}

	@Override
	public APIResponseModel delete(long id) {
		APIResponseModel response = null;
		try {
			StudentRepository.deleteById(id);
			response = utils.getResponseModel(AdminServiceConstants.CODE_SUCCESS,
					AdminServiceConstants.MESSAGE_SUCCESS);
		} catch (Exception e) {
			response = utils.getResponseModel(AdminServiceConstants.CODE_EXCEPTION,
					AdminServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}

	@Override
	public APIResponseModel findByTeacherId(long teacherId) {
		APIResponseModel response = null;
		try {
			Teacher teacher = TeacherRepository.findById(teacherId).get();
			response = utils.getResponseModel(AdminServiceConstants.CODE_SUCCESS,
					AdminServiceConstants.MESSAGE_SUCCESS, teacher);
		} catch (Exception e) {
			response = utils.getResponseModel(AdminServiceConstants.CODE_EXCEPTION,
					AdminServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}

	@Override
	public APIResponseModel findAllStudents() {
		APIResponseModel response = null;
		try {
			List<Student> studentList = (List<Student>) StudentRepository.findAll();
			response = utils.getResponseModel(AdminServiceConstants.CODE_SUCCESS,studentList,
					AdminServiceConstants.MESSAGE_SUCCESS);
		} catch (Exception e) {
			response = utils.getResponseModel(AdminServiceConstants.CODE_EXCEPTION,
					AdminServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}

	@Override
	public APIResponseModel findAllTeachers() {
		APIResponseModel response = null;
		try {
			List<Teacher> teacherList = (List<Teacher>) TeacherRepository.findAll();
			response = utils.getResponseModel(AdminServiceConstants.CODE_SUCCESS,
					AdminServiceConstants.MESSAGE_SUCCESS,teacherList);
		} catch (Exception e) {
			response = utils.getResponseModel(AdminServiceConstants.CODE_EXCEPTION,
					AdminServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}
		
	
	@Override
	public APIResponseModel getReport() {
		APIResponseModel response = null;
		try {
			List<Attendance> attendanceList = (List<Attendance>) AttendanceRepository.findAll();
			response = utils.getResponseModel(attendanceList,AdminServiceConstants.CODE_SUCCESS,
					AdminServiceConstants.MESSAGE_SUCCESS);
		} catch (Exception e) {
			response = utils.getResponseModel(AdminServiceConstants.CODE_EXCEPTION,
					AdminServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}
	
	  @Override 
	  public void markAttendance(Attendance attendance) { 
		  Attendance attendanceToUpdate= AttendanceRepository.findById(attendance.getCourse_id()).get();
//		  List<Attendance> attendanceToUpdates= AttendanceRepository.findAllById(attendance.getCourse_id()).get();
		  attendanceToUpdate.setAttended(attendance.getAttended());
		  AttendanceRepository.save(attendanceToUpdate); }
	 

}
