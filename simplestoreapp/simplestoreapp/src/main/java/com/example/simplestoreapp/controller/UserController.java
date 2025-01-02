package com.example.simplestoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.simplestoreapp.entity.Admin;
import com.example.simplestoreapp.entity.User;
import com.example.simplestoreapp.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/add/user")
	public String addUser() {
		return "AddUser";
	}
	
	@PostMapping("/add/user")
	public String addUser(User user) {
		userService.createUser(user);
		
		return "Login";
	}
	
	@GetMapping("/update/user/{id}")
	public String updateUser(@PathVariable Long id,Model model) {
		model.addAttribute("admin",userService.getUserById(id));
		
		return "UpdateUser";
		
	}
	
	@PostMapping("/update/user")
	public String updateUser(User user) {
		userService.updateUser(user);
		
		return "/admin/home";	
	}
	
	@DeleteMapping("/delete/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "/admin/home";
		
	}
	
	
	
	

}
