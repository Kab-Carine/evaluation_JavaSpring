package com.example.payMe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.payMe.model.User;
import com.example.payMe.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public User getUserByName(String userName) {
		return userRepository.getUserByName(userName);
	}

	public void save(User user) {
		userRepository.save(user);

	}

	/*List<User> userListe = new ArrayList<>();

	public  List<User> getAllUser(){
		return  (List<User>) userRepository.findAll();
		
	}*/
	
	public List<User> getAllUser(){
		return (List<User>) userRepository.findAll();
	}
	
	public User getConnectedUser() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.getUserByName(userName);
		return user;
	}

	public User getUserById(Long userid) {
		// TODO Auto-generated method stub
		return userRepository.findById(userid).get();
	}

	
}



