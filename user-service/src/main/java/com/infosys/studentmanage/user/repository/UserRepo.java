package com.infosys.studentmanage.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infosys.studentmanage.user.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

}
