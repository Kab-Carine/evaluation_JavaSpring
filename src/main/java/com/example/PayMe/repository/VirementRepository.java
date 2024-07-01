package com.example.payMe.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.payMe.model.User;
import com.example.payMe.model.Virement;

@Repository
public interface VirementRepository extends CrudRepository<Virement, Long> {
	
	List<Virement> findAllByUser(User user);
}
