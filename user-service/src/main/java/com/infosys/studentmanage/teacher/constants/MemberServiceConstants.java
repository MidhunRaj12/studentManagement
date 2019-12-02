package com.infosys.studentmanage.teacher.constants;

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
	
	public static final String RETURNED = "Returned";
	public static final String ISSUED = "Issued";
	public static final String REJECTED = "Rejected";
	public static final String NEW = "New";
	public static final String AVAILABLE = "Available";
	public static final List<String> STATUS_LIST = new ArrayList<String>(Arrays.asList(ISSUED,RETURNED,REJECTED,NEW));
	public static final String CODE_INVALID_STATUS = "406";
	public static final String MESSAGE_INVALID_STATUS = "Invalid status";
	
	public static final String CODE_EXCEPTION = "407";
	public static final String MESSAGE_EXCEPTION = "Some issue occurred in the system. The Exception details are ";
	
	public static final String ADMIN_ROLE = "ROLE_ADMIN";
	public static final String USER_ROLE = "ROLE_USER";
	public static final List<String> ROLE_LIST = new ArrayList<String>(Arrays.asList(ADMIN_ROLE,USER_ROLE));
	public static final String CODE_INVALID_ROLE = "408";
	public static final String MESSAGE_INVALID_ROLE = "Invalid user role";
	
	public static final String CODE_KAFKA_ERROR = "409";
	public static final String MESSAGE_KAFKA_ERROR = "Status Update successful but update via Kafka failed";
	
	public static final String REPORT_TYPE_ISSUED = "issued";
	public static final String REPORT_TYPE_RETURNED = "returned";
	public static final List<String> REPORT_TYPE_LIST = new ArrayList<String>(Arrays.asList("issued","returned"));
	
	public static enum ReportTypeEnum {issued, returned}

}
