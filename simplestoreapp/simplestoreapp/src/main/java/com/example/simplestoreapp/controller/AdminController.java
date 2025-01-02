package com.example.simplestoreapp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.simplestoreapp.entity.Admin;
import com.example.simplestoreapp.entity.Order;
import com.example.simplestoreapp.entity.User;
import com.example.simplestoreapp.service.AdminService;
import com.example.simplestoreapp.service.OrderService;
import com.example.simplestoreapp.service.ProductService;
import com.example.simplestoreapp.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	private User user;
	
	@GetMapping("/verifyCredentials")
	public String verifyCredentials(@ModelAttribute("admin") Admin admin,Model model) {
		if(adminService.verifyCredentials(admin.getEmail(),admin.getPassword())) {
			return "";
		}
		model.addAttribute("error","Invalid email or password");
		return "Login";
	}
	
	@GetMapping("/admin/home")
	public String adminHomePage(Model model) {
		model.addAttribute("adminList",adminService.getAllAdmin());
		model.addAttribute("userList",userService.getAllUser());
		model.addAttribute("oderList",orderService.getAllOrder());
		model.addAttribute("productList",productService.getAllProduct());

		
		return "AdminHomePage";
	}
	
	@GetMapping("/add/admin")
	public String createAdmin() {
		return "AddAdmin";
	}
	
	@PostMapping("/add/admin")
	public String createAdmin(Admin admin) {
		adminService.createUser(admin);
		
		return "/admin/home";
	}
	@GetMapping("/update/admin/{id}")
	public String updateAdmin(@PathVariable Long id,Model model) {
		model.addAttribute("admin",adminService.getAdminById(id));
		
		return "UpdateAdmin";
		
	}
	
	@PostMapping("/update/admin")
	public String updateAdmin(Admin admin) {
		adminService.updateAdmin(admin);
		
		return "/admin/home";
		
	}
	
	@DeleteMapping("/delete/admin/{id}")
	public String deleteAdmin(@PathVariable Long id) {
		adminService.deleteAdmin(id);
		return"/admin/home";
		
	}
	
	@GetMapping("/user/login")
	public String userLogin(User user,Model model) {
		if(userService.verifyCredentials(user.getEmail(), user.getPassword())) {
			user= userService.findUserByEmail(user.getEmail());
			model.addAttribute("ordersList",orderService.findOrdersByUser(user));
			
			return "ProductPage";
		}
		
		model.addAttribute("error","Invalid email or password");
		return "Login";
		
	}
	
	
	@GetMapping("/place/order")
	public String placeOrder(Order order,Model model) {
		double totalAmount = order.getPrice()*order.getQuantity();
		order.setAmount(totalAmount);
		order.setUser(user);
		order.setDate(new Date());
		
		orderService.createOrder(order);
		model.addAttribute("amount",totalAmount);
		return "OrderStatus";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
