package com.example.simplestoreapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simplestoreapp.entity.Product;
import com.example.simplestoreapp.repo.ProductRepo;
import com.example.simplestoreapp.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public List<Product> getAllProduct(){
		return productRepo.findAll();
	}
	
	public Product getProductById(Long id) {
		return productRepo.findById(id).orElseThrow(()->new RuntimeException("Admin with id "+id+" not found"));
	}
	
	public void createProduct(Product Product) {
		productRepo.save(Product);
	}
	
	public void updateProduct(Product Product) {
		productRepo.findById(Product.getId()).orElseThrow(()->new RuntimeException("Admin with id "+Product.getId()+" not found"));
		productRepo.save(Product);
	}
	
	public void deleteProduct(Long id) {
		productRepo.findById(id).orElseThrow(()->new RuntimeException("Admin with id "+id+" not found"));
		productRepo.deleteById(id);
	}
	

	

}
