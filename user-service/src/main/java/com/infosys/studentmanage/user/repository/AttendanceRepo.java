package com.infosys.studentmanage.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infosys.studentmanage.user.model.Attendance;


@Repository
public interface AttendanceRepo extends CrudRepository<Attendance, Long>{
	
	List<Attendance> findByStudentId(Long Id);
	
}
