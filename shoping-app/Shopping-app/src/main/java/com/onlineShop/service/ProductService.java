package com.onlineShop.service;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Service;

import com.onlineShop.model.Product;
@Service
public interface ProductService {
    boolean deleteItem(Long id);

    Product addItem(Product item);

    Product updateItem(Long id, Product item);
    List<Product> viewItem();
    List<Product> viewItem(Long id);
}
