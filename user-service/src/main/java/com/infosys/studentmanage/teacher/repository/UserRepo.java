package com.infosys.studentmanage.teacher.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infosys.studentmanage.teacher.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

}
