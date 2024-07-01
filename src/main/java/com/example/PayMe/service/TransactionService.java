package com.example.payMe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payMe.model.Transaction;
import com.example.payMe.model.User;
import com.example.payMe.repository.TransactionRepository;
import com.example.payMe.repository.UserRepository;

@Service
public class TransactionService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TransactionRepository transactionRepository;

	public List<Transaction> getTransactionListByUserName(String userName) {
		User user = userRepository.getUserByName(userName);
		 List<Transaction> transactions = transactionRepository.findAllBySender(user);	
		 return transactions;
	}
	
	public List<Transaction> getTransactionListByUser(String userName) {
		User user = userRepository.getUserByName(userName);
		 List<Transaction> transactions = transactionRepository.findAllByReceiver(user);		
		 return transactions;
	}

	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
	}

}
