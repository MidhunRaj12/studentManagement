package com.infosys.studentmanage.user.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.infosys.studentmanage.user.model.APIResponseModel;
import com.infosys.studentmanage.user.model.AttendanceHistory;
import com.infosys.studentmanage.user.model.AttendanceHistoryDTO;
import com.infosys.studentmanage.user.model.StudentDTO;
import com.infosys.studentmanage.user.model.User;

@Component
public class AttendanceUtils {
	
	public Map<Long, StudentDTO> getAttendanceMap(List<StudentDTO> AttendanceList)
	{
     	Map<Long, StudentDTO> AttendanceMap = new HashMap<Long, StudentDTO>();
//		AttendanceList.forEach(attendanceDTO -> AttendanceMap.put(StudentDTO.getId(), StudentDTO));
		return AttendanceMap;
	}
	
	public List<Long> getAttendanceList(List<AttendanceHistory> daoObjectList)
	{
		List<Long> attendanceList = new ArrayList<Long>();
		daoObjectList.forEach(daoObject -> attendanceList.add(daoObject.getBookId()));
		return attendanceList;
	}
	
	public APIResponseModel getResponseModel(String responseCode, String description)
	{
		APIResponseModel response = new APIResponseModel();
		response.setResponseCode(responseCode);
		response.setDescription(description);
		return response;
	}
	
	public APIResponseModel getResponseModel(String responseCode, String description, User member)
	{
		APIResponseModel response = new APIResponseModel();
		response.setResponseCode(responseCode);
		response.setDescription(description);
		response.setMember(member);
		return response;
	}
}
