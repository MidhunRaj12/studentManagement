package com.infosys.studentmanage.teacher.controller;


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
import com.infosys.studentmanage.teacher.TeacherServiceApplication;
import com.infosys.studentmanage.teacher.constants.MemberServiceConstants;
import com.infosys.studentmanage.teacher.constants.MemberServiceConstants.ReportTypeEnum;
import com.infosys.studentmanage.teacher.model.APIResponseModel;
import com.infosys.studentmanage.teacher.model.BookIssueHistory;
import com.infosys.studentmanage.teacher.model.User;
import com.infosys.studentmanage.teacher.service.StudentService;
import com.infosys.studentmanage.teacher.service.TeacherService;

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
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping()
	public APIResponseModel addMember(@RequestBody User member)
	{
		return teacherService.save(member);
	}
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping(value = "/raiseRequest")
	public APIResponseModel raiseBookRequest(@RequestBody BookIssueHistory bookIssueHistory)
	{
		return bookIssueService.save(bookIssueHistory);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{issueId}")
	public APIResponseModel raiseBookRequest(@PathVariable long issueId, @FormParam(value = "status") String status)
	{
		return bookIssueService.update(issueId, status);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping(value = "/Teacher/{teacherId}")
	public APIResponseModel fetchIssuedBooks(@PathVariable ReportTypeEnum teacherId)
	{
		if(ReportTypeEnum.issued.equals(teacherId))
		{
			String oauthHeader = request.getHeader(MemberServiceConstants.OAUTH_HEADER);
			return bookIssueService.fetchIssuedBooks(oauthHeader);
		}
		else
			return null;
			
		
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping(value = "/student/{Id}/")
	public APIResponseModel fetchMemberIssuedBooks(@PathVariable long Id)
	{
		if(ReportTypeEnum.issued.equals(reportType))
		{
			String oauthHeader = request.getHeader(MemberServiceConstants.OAUTH_HEADER);
			return bookIssueService.fetchMemberIssuedBooks(Id, oauthHeader);
		}

		else
			return null;
	}
	@PreAuthorize("hasRole('USER')")
	@GetMapping(value = "/attendance/{Id}/")
	public APIResponseModel fetchMemberIssuedBooks(@PathVariable long Id)
	{
		if(ReportTypeEnum.issued.equals(reportType))
		{
			String oauthHeader = request.getHeader(MemberServiceConstants.OAUTH_HEADER);
			return bookIssueService.fetchMemberIssuedBooks(Id, oauthHeader);
		}

		else
			return null;
	}

}
