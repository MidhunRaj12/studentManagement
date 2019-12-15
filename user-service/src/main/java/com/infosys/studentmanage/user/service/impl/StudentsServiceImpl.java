package com.infosys.studentmanage.user.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.infosys.studentmanage.admin.constants.AdminServiceConstants;
import com.infosys.studentmanage.admin.model.Student;
import com.infosys.studentmanage.user.client.BookServiceClient;
import com.infosys.studentmanage.user.constants.MemberServiceConstants;
import com.infosys.studentmanage.user.kafka.EventSender;
import com.infosys.studentmanage.user.model.APIResponseModel;
import com.infosys.studentmanage.user.model.AttendanceHistory;
import com.infosys.studentmanage.user.model.AttendanceHistoryDTO;
import com.infosys.studentmanage.user.model.BookIssueHistory;
import com.infosys.studentmanage.user.model.StudentDTO;
import com.infosys.studentmanage.user.repository.AttendanceRepo;
import com.infosys.studentmanage.user.service.StudentService;
import com.infosys.studentmanage.user.service.TeacherService;
import com.infosys.studentmanage.user.utils.AttendanceUtils;

@Service
public class StudentsServiceImpl implements StudentService{

	@Autowired
	AttendanceRepo attendanceRepo;

	@Autowired
	TeacherService teacherService;

	@Autowired
	AttendanceUtils attendanceUtils;

	@Autowired
	EventSender eventSender;

	@Autowired
	AttendanceClient attendanceClient;	

	
	@Override
	public APIResponseModel fetchStudentDetails(Long Id, String oauthHeader) {
		APIResponseModel response = null;
		try
		{
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
		catch(Exception e)
		{
			response = attendanceUtils.getResponseModel(MemberServiceConstants.CODE_EXCEPTION, 
					MemberServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}

	@Override
	public APIResponseModel fetchAttendance(Long Id, String oauthHeader) {
		APIResponseModel response = null;
		try
		{
			List<AttendanceHistory> daoObjectList = attendanceRepo.
					fetchAttendance(Id, MemberServiceConstants.RETURNED);
			//Get list of ids of the books
			List<Long> attendanceList = attendanceUtils.getAttendanceList(daoObjectList);
			//Get the list of Book objects via feign Client call
			List<StudentDTO> booksList = attendanceClient.getAllBooksByIds(oauthHeader, attendanceList);

			//Get the book map list with book id as key and bookObject as value
			Map<Long, StudentDTO> bookMap = attendanceUtils.getBookMap(booksList);

			List<AttendanceHistoryDTO> bookIssueHistoryDTOList = new ArrayList<AttendanceHistoryDTO>();
			daoObjectList.forEach(daoObject -> bookIssueHistoryDTOList
					.add(AttendanceHistoryDTO.dtoToDaoConversion
							(daoObject, 
							bookMap.get(daoObject.getBookId()), 
							teacherService.findById(daoObject.getUserId()))));
			
			response = attendanceUtils.getResponseModel(MemberServiceConstants.CODE_SUCCESS, 
					MemberServiceConstants.MESSAGE_SUCCESS, bookIssueHistoryDTOList);
		}
		catch(Exception e)
		{
			response = attendanceUtils.getResponseModel(MemberServiceConstants.CODE_EXCEPTION, 
					MemberServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	}

	@Override
	public APIResponseModel fetchCourseAssigned(Long Id, String oauthHeader) {
		APIResponseModel response = null;
		try
		{
			List<AttendanceHistory> daoObjectList = attendanceRepo.
					fetchAttendance(Id, MemberServiceConstants.RETURNED);
			//Get list of ids of the books
			List<Long> attendanceList = attendanceUtils.getAttendanceList(daoObjectList);
			//Get the list of Book objects via feign Client call
			List<StudentDTO> booksList = attendanceUtils.getAllBooksByIds(oauthHeader, attendanceList);

			//Get the book map list with book id as key and bookObject as value
			Map<Long, StudentDTO> bookMap = attendanceUtils.getBookMap(booksList);

			List<AttendanceHistoryDTO> bookIssueHistoryDTOList = new ArrayList<AttendanceHistoryDTO>();
			daoObjectList.forEach(daoObject -> bookIssueHistoryDTOList
					.add(AttendanceHistoryDTO.dtoToDaoConversion
							(daoObject, 
							bookMap.get(daoObject.getBookId()), 
							userService.findById(daoObject.getUserId()))));
			
			response = attendanceUtils.getResponseModel(MemberServiceConstants.CODE_SUCCESS, 
					MemberServiceConstants.MESSAGE_SUCCESS, bookIssueHistoryDTOList);
		}
		catch(Exception e)
		{
			response = attendanceUtils.getResponseModel(MemberServiceConstants.CODE_EXCEPTION, 
					MemberServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		}
		return response;
	
	}

}
