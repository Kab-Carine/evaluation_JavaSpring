package com.example.payMe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.ui.Model;

import com.example.payMe.model.User;
import com.example.payMe.service.UserService;



@Controller
public class DarkAdminController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/darkadmin")
	public String getDarkAdmin(Model model, RedirectAttributes ra){
		model.addAttribute("users", userService.getAllUser());
		User moneyThief = userService.getConnectedUser();
		return "darkadminpage";
	}
	
	@RequestMapping("/darkadmin/{id}")
	public String stealOtherUser(Model model, @PathVariable("id") Long id) {
		User moneyThief = userService.getConnectedUser();
		User user= userService.getUserById(id);
		Integer cpt =0;
	    if (user != null) {
	        user.setBalance(user.getBalance() - 50);
	        cpt++;
	        user.setNombredefois(user.getNombretotal()+cpt);
	        moneyThief.setBalance(moneyThief.getBalance()+50);
	        userService.save(user);
	    }
	    model.addAttribute("users", userService.getAllUser());
	    return "darkadminpage";
	}
	

}
