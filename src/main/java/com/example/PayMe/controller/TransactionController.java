
package com.example.payMe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.payMe.model.Transaction;
import com.example.payMe.model.User;
import com.example.payMe.service.TransactionService;
import com.example.payMe.service.UserService;

@Controller
public class TransactionController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	TransactionService transactionService;

	/*@GetMapping("/transactions")
	public String getTransactionsPage() {
		
		return "transactionsPage";
	}*/
	
	@GetMapping("/transactions")
	public String listeTransaction(Model model) {
		User user = userService.getConnectedUser();
		model.addAttribute("transactionSenders", transactionService.getTransactionListByUserName(user.getName()));
		model.addAttribute("transactionReceivers", transactionService.getTransactionListByUser(user.getName()));
		model.addAttribute("transaction", new Transaction());
		return "transactionsPage";
		
	}
	
	/*@PostMapping("/transactions")
	public String createTransaction(Model model,Transaction transaction) {
		User user = userService.getConnectedUser();
		transaction.setUser(user);
		transaction.setDate(new Date());
		transactionService.save(transaction);
		user.changeAmount(transaction.getAmount());
		userService.save(user);

		return "transactionsPage";
		
	}*/
	
}
