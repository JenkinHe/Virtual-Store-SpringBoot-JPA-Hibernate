package com.example.simplestoreapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simplestoreapp.entity.User;
import com.example.simplestoreapp.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	public User getUserById(Long id) {
		return userRepo.findById(id).orElseThrow(()->new RuntimeException("Admin with id "+id+" not found"));
	}
	
	public void createUser(User user) {
		userRepo.save(user);
	}
	
	public void updateUser(User user) {
		userRepo.findById(user.getId()).orElseThrow(()->new RuntimeException("Admin with id "+user.getId()+" not found"));
		userRepo.save(user);
	}
	
	public void deleteUser(Long id) {
		userRepo.findById(id).orElseThrow(()->new RuntimeException("Admin with id "+id+" not found"));
		userRepo.deleteById(id);
	}
	
	public boolean verifyCredentials(String email, String password) {
		User user =userRepo.findByEmail(email);
		if(user.getPassword()==password) {
			return true;
		}
		return false;
	}
	

}
