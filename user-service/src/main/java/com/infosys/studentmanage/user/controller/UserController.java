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
import com.infosys.studentmanage.user.constants.MemberServiceConstants.ReportTypeEnum;
import com.infosys.studentmanage.user.model.APIResponseModel;
import com.infosys.studentmanage.user.model.AttendanceHistory;
import com.infosys.studentmanage.user.model.User;
import com.infosys.studentmanage.user.service.StudentService;
import com.infosys.studentmanage.user.service.TeacherService;

@RestController
@RequestMapping("/users")
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
	
//	@PreAuthorize("hasRole('USER')")
//	@PostMapping("/student")
//	public APIResponseModel addMember(@RequestBody User member)
//	{
//		return teacherService.save(member);
//	}
//	
//	@PreAuthorize("hasRole('USER')")
//	@PostMapping(value = "/raiseRequest")
//	public APIResponseModel raiseBookRequest(@RequestBody AttendanceHistory attendanceHistory)
//	{
//		return teacherService.save(attendanceHistory);
//	}
//	
//	@PreAuthorize("hasRole('ADMIN')")
//	@PutMapping(value = "/{issueId}")
//	public APIResponseModel raiseBookRequest(@PathVariable long issueId, @FormParam(value = "status") String status)
//	{
//		return teacherService.update(issueId, status);
//	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping(value = "/teacher/{teacherId}")
	public APIResponseModel fetchSchedule(@PathVariable long teacherId)
	{
//		if(teacherId)
//		{
			String oauthHeader = request.getHeader(MemberServiceConstants.OAUTH_HEADER);
			return teacherService.fetchCourseSchedule(teacherId, oauthHeader);
//		}
//		else
//			return null;
			
		
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping(value = "/student/{Id}/")
	public APIResponseModel fetchStudentDetails(@PathVariable long Id)
	{
//		if(ReportTypeEnum.issued.equals(reportType))
//		{
			String oauthHeader = request.getHeader(MemberServiceConstants.OAUTH_HEADER);
			return studentService.fetchStudentDetails(Id, oauthHeader);
		}

//		else
//			return null;
//	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping(value = "/student/attendance/{Id}/")
	public APIResponseModel viewAttendance(@PathVariable long Id)
	{
//		if(ReportTypeEnum.issued.equals(reportType))
//		{
			String oauthHeader = request.getHeader(MemberServiceConstants.OAUTH_HEADER);
			return studentService.fetchAttendance(Id, oauthHeader);
		}

//		else
//			return null;
//	}

	@PreAuthorize("hasRole('USER')")
	@PostMapping(value = "/teacher/attendance/{Id}/")
	public APIResponseModel raiseBookRequest(@RequestBody AttendanceHistory attendanceHistory)
	{
		//return teacherService.save(attendanceHistory);
		return null;
	}


}
