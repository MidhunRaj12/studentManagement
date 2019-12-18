package com.infosys.studentmanage.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infosys.studentmanage.user.model.Teacher;


@Repository
public interface TeacherRepo extends CrudRepository<Teacher, Long>{
	
}
