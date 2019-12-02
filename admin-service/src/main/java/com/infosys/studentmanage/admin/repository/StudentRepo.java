package com.infosys.studentmanage.admin.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infosys.studentmanage.admin.model.Student;


@Repository
public interface StudentRepo extends CrudRepository<Student, Long>{


}
