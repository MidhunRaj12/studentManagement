package com.infosys.studentmanage.user.controller;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infosys.studentmanage.user.UserServiceApplication;
import com.infosys.studentmanage.user.constants.MemberServiceConstants;
import com.infosys.studentmanage.user.model.APIResponseModel;
import com.infosys.studentmanage.user.model.Attendance;
import com.infosys.studentmanage.user.model.User;
import com.infosys.studentmanage.user.service.StudentService;
import com.infosys.studentmanage.user.service.TeacherService;

@RestController
@RequestMapping("/user")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {
	
	@Autowired
	TeacherService teacherService;
	@Autowired
	StudentService studentService;
	
	private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
	@Autowired
    public UserController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
	
	@PreAuthorize("hasRole('STUDENT')")
	@GetMapping("/student/{Id}")
	public APIResponseModel studentDetails(@PathVariable("Id") Long Id)
	{
		return studentService.findStudentById(Id);
	}
	
	@PreAuthorize("hasRole('TEACHER')")
	@GetMapping("/teacher/{Id}")
	public APIResponseModel teacherDetails(@PathVariable("Id") Long Id)
	{
		return teacherService.findTeacerById(Id);
	}
	
	@PreAuthorize("hasRole('TEACHER')")
	@GetMapping(value = "/teacher/schedule/{teacherId}")
	public APIResponseModel fetchSchedule(@PathVariable Long teacherId)
	{
			return teacherService.fetchCourseSchedule(teacherId);		
		
	}
	
	@PreAuthorize("hasRole('TEACHER')")
	@GetMapping(value = "/teacher/studentdetail/{Id}")
	public APIResponseModel fetchStudentDetails(@PathVariable Long Id)
	{
			return teacherService.fetchStudentDetails(Id);
	}

	@PreAuthorize("hasRole('STUDENT')")
	@GetMapping(value = "/student/attendance/{Id}")
	public APIResponseModel viewAttendance(@PathVariable long Id)
	{
			return studentService.fetchAttendance(Id);
	}

	@PreAuthorize("hasRole('TEACHER')")
	@PostMapping(value = "/teacher/attendance")
	public APIResponseModel markAttendance(@RequestBody Attendance attendance)
	{
		teacherService.markAttendance(attendance);
		return null;
	}


}
