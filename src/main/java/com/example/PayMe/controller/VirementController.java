package com.example.payMe.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.payMe.model.User;
import com.example.payMe.model.Virement;
import com.example.payMe.service.UserService;
import com.example.payMe.service.VirementService;


@Controller
public class VirementController {
	
	@Autowired
	VirementService virementService;
	
	@Autowired
	UserService userService;


	
	@GetMapping("/virements")
	public String getVirementsPage(Model model) {
		User user = userService.getConnectedUser();
		model.addAttribute("virements", virementService.getVirementListByUserName(user.getName()));
		model.addAttribute("virement", new Virement());
		return "virementsPage";
	}
	
	
	@PostMapping("/virements")
	public String createVirement(Model model, Virement virement){
		User user = userService.getConnectedUser();
		virement.setUser(user);
		virement.setDate(new Date());
		virementService.save(virement);
		user.changeAmount(virement.getAmount());
		userService.save(user);

		model.addAttribute("virements", virementService.getVirementListByUserName(user.getName()));
		model.addAttribute("virement", new Virement());
		return "virementsPage";
		}
}


