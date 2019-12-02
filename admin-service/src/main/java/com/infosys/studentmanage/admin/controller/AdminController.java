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
	@PutMapping("/student/{RegNo}")
	public APIResponseModel updateStudent(@PathVariable("RegNo") Long RegNo)
	{
		return adminService.update(RegNo);
	}
	
	@GetMapping(value = "/student/{RegNo}")
	public APIResponseModel getStudent(@PathVariable("RegNo") Long RegNo)
	{
		return adminService.findById(RegNo);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/student/{RegNo}")
	public APIResponseModel deleteStudent(@PathVariable("RegNo") Long RegNo)
	{
		return adminService.delete(RegNo);
	}
	
	@GetMapping(value = "/fetchStudents")
	public List<Student> getAllStudents()
	{
		return adminService.findAllStudents();
	}
	
	@GetMapping(value = "/findTeacher/{TeacherId}")
	public APIResponseModel getTeacher(@PathVariable Long teacherId)
	{
		return adminService.findByTeacherId(teacherId);
	}
	
	@GetMapping(value = "/fetchTeachers")
	public List<Teacher> getAllTeachers()
	{
		return adminService.findAllTeachers();
	}
	
	

}
