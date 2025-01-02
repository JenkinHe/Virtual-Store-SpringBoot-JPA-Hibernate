package com.example.simplestoreapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simplestoreapp.entity.Admin;
import com.example.simplestoreapp.entity.Order;
import com.example.simplestoreapp.entity.Product;
import com.example.simplestoreapp.entity.User;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long>{
	public Order findByUser(User user);

}