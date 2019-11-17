package com.retailbilling.productservice;

import java.util.List;

import com.retailbilling.product.Product;

public interface ProductService {
	public void addProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProduct(int id);
}
