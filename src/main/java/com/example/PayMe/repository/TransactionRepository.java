package com.example.payMe.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.payMe.model.Transaction;
import com.example.payMe.model.User;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

	List<Transaction> findAllBySender(User sender);
	List<Transaction> findAllByReceiver(User receiver);

}
