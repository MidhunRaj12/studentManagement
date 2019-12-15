package com.infosys.studentmanage.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infosys.studentmanage.user.model.AttendanceHistory;

@Repository
public interface AttendanceRepo extends CrudRepository<AttendanceHistory, Long>{
	
	List<AttendanceHistory> findByStudentId(Long Id);
	
	/*
	 * List<BookIssueHistory> findByMemberIdAndStatus(long memberId, String status);
	 */

}
