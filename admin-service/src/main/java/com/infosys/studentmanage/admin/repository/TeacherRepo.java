package com.infosys.studentmanage.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infosys.studentmanage.admin.model.Attendance;
import com.infosys.studentmanage.admin.model.Teacher;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher, Long>{
	
}
