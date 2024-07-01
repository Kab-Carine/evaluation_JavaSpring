package com.example.payMe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payMe.model.User;
import com.example.payMe.model.Virement;
import com.example.payMe.repository.UserRepository;
import com.example.payMe.repository.VirementRepository;

@Service
public class VirementService {

	@Autowired
	VirementRepository virementRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<Virement> getVirementListByUserName(String userName) {
		User user = userRepository.getUserByName(userName);
		 List<Virement> virements = virementRepository.findAllByUser(user);		
		 return virements;
	}
	
	public void save(Virement virement) {
		virementRepository.save(virement);
	}



}
