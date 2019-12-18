package com.infosys.studentmanage.admin.utils;

import java.util.List;

import org.springframework.stereotype.Component;

import com.infosys.studentmanage.admin.model.APIResponseModel;
import com.infosys.studentmanage.admin.model.Attendance;
import com.infosys.studentmanage.admin.model.Teacher;
import com.infosys.studentmanage.admin.model.Student;

@Component
public class AdminServiceUtils {
	
	public APIResponseModel getResponseModel(String responseCode, String description)
	{
		APIResponseModel response = new APIResponseModel();
		response.setResponseCode(responseCode);
		response.setDescription(description);
		return response;
	}
	
	public APIResponseModel getResponseModel(String responseCode, String description, Student student)
	{
		APIResponseModel response = new APIResponseModel();
		response.setResponseCode(responseCode);
		response.setDescription(description);
		response.setStudent(student);
		return response;
	}
	
	public APIResponseModel getResponseModel(String responseCode, String description, Teacher teacher)
	{
		APIResponseModel response = new APIResponseModel();
		response.setResponseCode(responseCode);
		response.setDescription(description);
		response.setTeacher(teacher);
		return response;
	}
	public APIResponseModel getResponseModel(String responseCode,List<Student> students,String description)
	{
		APIResponseModel response = new APIResponseModel();
		response.setResponseCode(responseCode);
		response.setDescription(description);
		response.setStudents(students);
		return response;
	}
	
	public APIResponseModel getResponseModel(String responseCode, String description, List<Teacher> teachers)
	{
		APIResponseModel response = new APIResponseModel();
		response.setResponseCode(responseCode);
		response.setDescription(description);
		response.setTeachers(teachers);
		return response;
	}

	
	public APIResponseModel getResponseModel(List<Attendance> attendance, String responseCode, String description )
	{
		APIResponseModel response = new APIResponseModel();
		response.setResponseCode(responseCode);
		response.setDescription(description);
		response.setAttendance(attendance);
		return response;
	}
}
