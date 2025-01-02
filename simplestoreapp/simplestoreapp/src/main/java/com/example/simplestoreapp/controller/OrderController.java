package com.example.simplestoreapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.simplestoreapp.entity.Order;
import com.example.simplestoreapp.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired 
	private OrderService orderService;
	
	

}
