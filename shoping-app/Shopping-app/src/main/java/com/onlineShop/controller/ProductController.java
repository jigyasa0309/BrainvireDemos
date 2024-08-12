package com.onlineShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.onlineShop.model.Product;
import com.onlineShop.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	// creating product
	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN_ROLES')")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product createdProduct = productService.addItem(product);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

	// viwieing by id
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id) {
		List<Product> product = productService.viewItem(id);
		if (product != null) {
			return new ResponseEntity<Product>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	// for viewing all
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.viewItem();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	// for updating
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN_ROLES')")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product p = productService.updateItem(id, product);
		if (p != null) {
			return new ResponseEntity<Product>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	// for deleting
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ADMIN_ROLES')")
	public String deleteProduct(Long id) {
		if (productService.deleteItem(id)) {
			return "Product Deleted Succssfully";
		}
		return "No Record Found";
	}
}
