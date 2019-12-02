package com.infosys.studentmanage.teacher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.infosys.studentmanage.teacher.constants.MemberServiceConstants;
import com.infosys.studentmanage.teacher.model.APIResponseModel;
import com.infosys.studentmanage.teacher.model.User;
import com.infosys.studentmanage.teacher.repository.UserRepo;
import com.infosys.studentmanage.teacher.service.TeacherService;
import com.infosys.studentmanage.teacher.utils.AttendanceUtils;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	UserRepo memberRepository;
	
	@Autowired
	AttendanceUtils utils;
	
	@Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
	
	@Override
	public APIResponseModel save(User member) {
		APIResponseModel response = null;
		try
		{
			if(StringUtils.isEmpty(member.getMemberName()) || StringUtils.isEmpty(member.getPassword()))
			{
				response = utils.getResponseModel(MemberServiceConstants.CODE_INVALID_INPUT, 
						MemberServiceConstants.MESSAGE_INVALID_INPUT);
			}
			else if(StringUtils.isEmpty(member.getRoleId()))
			{
				response = utils.getResponseModel(MemberServiceConstants.CODE_INVALID_ROLE, 
						MemberServiceConstants.MESSAGE_INVALID_ROLE);
			}
			else
			{
				CharSequence csPassword = member.getPassword();
				member.setPassword(encoder().encode(csPassword));
				memberRepository.save(member);
				response = utils.getResponseModel(MemberServiceConstants.CODE_SUCCESS, 
						MemberServiceConstants.MESSAGE_SUCCESS, member);
			}
		}
		catch(Exception e)
		{

			response = utils.getResponseModel(MemberServiceConstants.CODE_EXCEPTION, 
					MemberServiceConstants.MESSAGE_EXCEPTION + e.getMessage());
		
		}
		return response;
	}

	@Override
	public User findById(Long id) {
		return memberRepository.findById(id).get();
	}

}
