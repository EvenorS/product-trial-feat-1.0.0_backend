package com.evenor.service;

import java.util.List;
import java.util.Optional;

import com.evenor.entity.Product;

public interface IProductService {
	
	public List<Product> findMeAll();
	public Optional<Product> findById(int id);
	public Product save(Product product);
	public void deleteById(int id);

}
