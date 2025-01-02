package com.example.simplestoreapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simplestoreapp.entity.Admin;
import com.example.simplestoreapp.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
	public User findByEmail(String email);

}
