package com.infosys.studentmanage.user.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.infosys.studentmanage.user.model.APIResponseModel;
import com.infosys.studentmanage.user.model.Attendance;
import com.infosys.studentmanage.user.model.AttendanceHistoryDTO;
import com.infosys.studentmanage.user.model.CourseSchedule;
import com.infosys.studentmanage.user.model.Student;
import com.infosys.studentmanage.user.model.Teacher;
import com.infosys.studentmanage.user.model.User;

@Component
public class AttendanceUtils {
	
//	public Map<Long, StudentDTO> getAttendanceMap(List<StudentDTO> AttendanceList)
//	{
//     	Map<Long, StudentDTO> AttendanceMap = new HashMap<Long, StudentDTO>();
////		AttendanceList.forEach(attendanceDTO -> AttendanceMap.put(StudentDTO.getId(), StudentDTO));
//		return AttendanceMap;
//	}
//	
//	public List<Long> getAttendanceList(List<Attendance> daoObjectList)
//	{
//		List<Long> attendanceList = new ArrayList<Long>();
//		daoObjectList.forEach(daoObject -> attendanceList.add(daoObject.getStudent_id()));
//		return attendanceList;
//	}
	
	public APIResponseModel getResponseModel(String responseCode, String description, List<Attendance> attendanceList)
	{
		APIResponseModel response = new APIResponseModel();
		response.setResponseCode(responseCode);
		response.setDescription(description);
		response.setAttendanceList(attendanceList);
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
	public APIResponseModel getResponseModel(String responseCode, String description, Attendance attendance)
	{
		APIResponseModel response = new APIResponseModel();
		response.setResponseCode(responseCode);
		response.setDescription(description);
		response.setAttendance(attendance);
		return response;
	}
	
	public APIResponseModel getResponseModel(String responseCode, List<CourseSchedule> courseScheduleList, String description)
	{
		APIResponseModel response = new APIResponseModel();
		response.setResponseCode(responseCode);
		response.setDescription(description);
		response.setCourseSchedule(courseScheduleList);
		return response;
	}
		
	public APIResponseModel getResponseModel(String responseCode, String description)
	{
		APIResponseModel response = new APIResponseModel();
		response.setResponseCode(responseCode);
		response.setDescription(description);
		return response;
	}
}
