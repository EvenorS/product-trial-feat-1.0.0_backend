package com.evenor.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evenor.entity.Product;

@Repository
public interface IProductDao extends JpaRepository<Product, Integer>{
	
	 
	

}
