package com.infosys.studentmanage.admin.controller;


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
	@GetMapping("")
	public String hellow()
	{
		return "heloo";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/student")
	public APIResponseModel addStudent(@RequestBody Student student)
	{	//System.out.println(student.getStudentName());
		return adminService.saveStudent(student);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/teacher")
	public APIResponseModel addTeacher(@RequestBody Teacher teacher)
	{	//System.out.println(student.getStudentName());
		return adminService.saveTeacher(teacher);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/student/update")
	public APIResponseModel updateStudent(@RequestBody Student student)
	{
		
		return adminService.updateStudent(student);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/teacher/update")
	public APIResponseModel updateTeacher(@RequestBody Teacher teacher)
	{
		
		return adminService.updateTeacher(teacher);
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
	public APIResponseModel getTeacher(@PathVariable("TeacherId") Long teacherId)
	{
		System.out.println(teacherId);
		return adminService.findByTeacherId(teacherId);
	}
	
	@GetMapping(value = "/fetchTeachers")
	public APIResponseModel getAllTeachers()
	{
		return adminService.findAllTeachers();
	}
	
	@GetMapping(value = "/attendanceReport")
	public APIResponseModel getReport()
	{
		return adminService.getReport();
	}
	

}
