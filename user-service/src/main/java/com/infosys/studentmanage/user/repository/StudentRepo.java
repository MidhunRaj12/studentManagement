package com.infosys.studentmanage.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infosys.studentmanage.user.model.Student;




@Repository
public interface StudentRepo extends CrudRepository<Student, Long>{


}
