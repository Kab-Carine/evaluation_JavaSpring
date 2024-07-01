package com.example.payMe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.payMe.model.User;

@Repository	
public interface UserRepository extends CrudRepository<User, Long>  {
	
	User getUserByName(String name);

}
