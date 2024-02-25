package com.evenor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evenor.entity.Product;
import com.evenor.service.ProductServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("products")
public class ProductsController {

	@Autowired
	private ProductServiceImpl productService;

	@GetMapping("")
	public List<Product> findAll() {
		return productService.findMeAll();
	}

	@GetMapping("/{id}")
	public Optional<Product> findById(@PathVariable("id") int id) {
		return productService.findById(id);
	}

	@PostMapping("")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		try {
			Product newProduct = productService.save(product);
			return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Product> UpdateProduct(@PathVariable("id") int id, @RequestBody Product newProduct) {

		Optional<Product> inDbProduct = productService.findById(id);

		if (inDbProduct.isPresent()) {
			Product oldProduct = productService.patchProduct(inDbProduct.get(), newProduct);
			return new ResponseEntity<>(productService.save(oldProduct), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {

		try {
			productService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
