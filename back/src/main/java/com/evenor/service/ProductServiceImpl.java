package com.evenor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.evenor.dao.IProductDao;
import com.evenor.entity.Product;


@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductDao productDao;

	@Override
	public List<Product> findMeAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Optional<Product> findById(int id) {
		// TODO Auto-generated method stub
		return productDao.findById(id);
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}
	
	public Product patchProduct(Product oldProduct, Product newProduct){
		
		if (newProduct.getCode() != null) {
			oldProduct.setCode(newProduct.getCode());
		}
		if (newProduct.getName() != null) {
			oldProduct.setName(newProduct.getName());
		}
		if (newProduct.getDescription() != null) {
			oldProduct.setDescription(newProduct.getDescription());
		}
		if (newProduct.getPrice() != 0) {
			oldProduct.setPrice(newProduct.getPrice());
		}
		if (newProduct.getQuantity() != 0) {
			oldProduct.setQuantity(newProduct.getQuantity());
		}
		if (newProduct.getInventoryStatus() != null) {
			oldProduct.setInventoryStatus(newProduct.getInventoryStatus());
		}
		if (newProduct.getCategory() != null) {
			oldProduct.setCategory(newProduct.getCategory());
		}
		if (newProduct.getImage() != null) {
			oldProduct.setImage(newProduct.getImage());
		}
		if (newProduct.getRating() != null) {
			oldProduct.setRating(newProduct.getRating());
		}
		return oldProduct;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		productDao.deleteById(id);
	}
	
	

}
