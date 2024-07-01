package com.example.payMe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.payMe.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	/*@GetMapping("/admin")
	public String listeUser(Model model) {
		model.addAttribute("listeUser", adminService.getAllUser());
		return "listeUser";
		
	}*/

}
