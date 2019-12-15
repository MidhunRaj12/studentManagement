package com.infosys.studentmanage.admin.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infosys.studentmanage.admin.model.APIResponseModel;
import com.infosys.studentmanage.admin.model.Student;
import com.infosys.studentmanage.admin.model.Teacher;
import com.infosys.studentmanage.admin.service.AdminService;

@RestController
@RequestMapping("/admin")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
	@Autowired
    public AdminController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/student")
	public APIResponseModel addStudent(@RequestBody Student student)
	{
		return adminService.save(student);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/student/{Id}")
	public APIResponseModel updateStudentCourse(@PathVariable("Id") Long Id)
	{
		return adminService.updateRegno(Id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/student/course/{Id}")
	public APIResponseModel updateStudentRegNo(@PathVariable("Id") Long Id)
	{
		return adminService.updateCourse(Id);
	}
	
	@GetMapping(value = "/student/{Id}")
	public APIResponseModel getStudent(@PathVariable("Id") Long Id)
	{
		return adminService.findById(Id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/student/{Id}")
	public APIResponseModel deleteStudent(@PathVariable("Id") Long Id)
	{
		return adminService.delete(Id);
	}
	
	@GetMapping(value = "/fetchStudents")
	public APIResponseModel getAllStudents()
	{
		return adminService.findAllStudents();
	}
	
	@GetMapping(value = "/findTeacher/{TeacherId}")
	public APIResponseModel getTeacher(@PathVariable Long teacherId)
	{
		return adminService.findByTeacherId(teacherId);
	}
	
	@GetMapping(value = "/fetchTeachers")
	public APIResponseModel getAllTeachers()
	{
		return adminService.findAllTeachers();
	}
	
	

}
