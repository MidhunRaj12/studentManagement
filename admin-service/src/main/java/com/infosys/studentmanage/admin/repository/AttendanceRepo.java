package com.infosys.studentmanage.admin.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infosys.studentmanage.admin.model.Attendance;


@Repository
public interface AttendanceRepo extends CrudRepository<Attendance, Long>{
	
	List<Attendance> findById(long Id);
}
