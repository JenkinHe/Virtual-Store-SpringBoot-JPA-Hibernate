package com.example.simplestoreapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simplestoreapp.entity.Admin;
import com.example.simplestoreapp.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{
	public Product findByName(String name);

}
