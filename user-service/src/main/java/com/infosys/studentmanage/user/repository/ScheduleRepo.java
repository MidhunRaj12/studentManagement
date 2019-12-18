package com.infosys.studentmanage.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.infosys.studentmanage.user.model.CourseSchedule;


@Repository
public interface ScheduleRepo extends CrudRepository<CourseSchedule, Long>{
	
	List<CourseSchedule> findByTeacherId(Long Id);

}