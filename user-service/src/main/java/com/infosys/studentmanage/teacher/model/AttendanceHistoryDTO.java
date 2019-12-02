package com.infosys.studentmanage.teacher.model;

import java.sql.Date;



public class AttendanceHistoryDTO {
	

    private long id;
    private long studentId;
    private Long bookId;
    private Date courseDate;
    private boolean attended;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Date getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}

	public boolean isAttended() {
		return attended;
	}

	public void setAttended(boolean attended) {
		this.attended = attended;
	}
    
   

	/*
	 * public static AttendanceHistoryDTO dtoToDaoConversion(BookIssueHistory
	 * daoObject, StudentDTO bookDTO, User memberDao) { AttendanceHistoryDTO
	 * bookIssueHistoryDTO = new AttendanceHistoryDTO();
	 * 
	 * bookIssueHistoryDTO.setId(daoObject.getId());
	 * bookIssueHistoryDTO.setBook(bookDTO);
	 * bookIssueHistoryDTO.setRequestDate(daoObject.getRequestDate());
	 * bookIssueHistoryDTO.setStatus(daoObject.getStatus());
	 * bookIssueHistoryDTO.setIssuedOn(daoObject.getIssuedOn());
	 * bookIssueHistoryDTO.setReturnedOn(daoObject.getReturnedOn());
	 * 
	 * UserDTO member = new UserDTO(); member.setId(memberDao.getId());
	 * member.setMemberName(memberDao.getMemberName());
	 * member.setPassword(memberDao.getPassword());
	 * member.setRoleId(memberDao.getRoleId()); member.setAge(memberDao.getAge());
	 * member.setAddress(memberDao.getAddress());
	 * bookIssueHistoryDTO.setMember(member);
	 * 
	 * return bookIssueHistoryDTO; }
	 */
}
