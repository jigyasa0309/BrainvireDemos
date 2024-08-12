package com.onlineShop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineShop.model.Product;
import com.onlineShop.repository.ProductRepository;
import com.onlineShop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addItem(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateItem(Long id, Product newProduct) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			Product existingProduct = optionalProduct.get();
			existingProduct.setName(newProduct.getName());
			existingProduct.setPrice(newProduct.getPrice());
			existingProduct.setDescription(newProduct.getDescription());

			return productRepository.save(existingProduct);
		} else {
			throw new RuntimeException("Product not found with id: " + id);
		}
	}

	@Override
	public List<Product> viewItem() {
		return productRepository.findAll();
	}

	@Override
	public boolean deleteItem(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		return true;

	}

	@Override
	public List<Product> viewItem(Long id) {
		List<Product> p = productRepository.findAll();
		return p;
	}
}
