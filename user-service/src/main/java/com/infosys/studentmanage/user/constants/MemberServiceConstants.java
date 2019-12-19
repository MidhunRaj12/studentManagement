package com.infosys.studentmanage.user.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemberServiceConstants {
	
	public static final String OAUTH_HEADER = "Authorization";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String APPLICATION_JSON = "application/json";
	
	public static final String BEARER_PREFIX = "Bearer ";
	
	public static final String CODE_SUCCESS = "200";
	public static final String MESSAGE_SUCCESS = "Success";
	
	public static final String CODE_INVALID_INPUT = "405";
	public static final String MESSAGE_INVALID_INPUT = "Invalid input";
	public static final String CODE_INVALID_STATUS = "406";
	
	public static final String CODE_EXCEPTION = "407";
	public static final String MESSAGE_EXCEPTION = "Some issue occurred in the system. The Exception details are ";
	
	public static final String ADMIN_ROLE = "ROLE_ADMIN";
	public static final String TEACHER_ROLE = "ROLE_TEACHER";
	public static final String STUDENT_ROLE = "STUDENT_USER";
	public static final List<String> ROLE_LIST = new ArrayList<String>(Arrays.asList(ADMIN_ROLE,TEACHER_ROLE,STUDENT_ROLE));
	public static final String CODE_INVALID_ROLE = "408";
	public static final String MESSAGE_INVALID_ROLE = "Invalid user role";
	
	public static final String CODE_KAFKA_ERROR = "409";
	public static final String MESSAGE_KAFKA_ERROR = "Attenndance Update successful but update via Kafka failed";
	

}
