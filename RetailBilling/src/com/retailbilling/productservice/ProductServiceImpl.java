package com.retailbilling.productservice;

import java.util.ArrayList;
import java.util.List;

import com.retailbilling.product.Product;

public class ProductServiceImpl implements ProductService {

	private static List<Product> prodList;
	private static ProductServiceImpl productServiceImpl = null;

	private ProductServiceImpl() {
		prodList = new ArrayList<Product>();
	}

	public static ProductServiceImpl getProductServiceImplInstance() {
		if (productServiceImpl == null)
			productServiceImpl = new ProductServiceImpl();
		return productServiceImpl;
	}

	@Override
	public void addProduct(Product product) {

		prodList.add(product);
	}

	@Override
	public List<Product> getAllProducts() {

		return prodList;
	}

	@Override
	public Product getProduct(int id) {

		return prodList.stream().filter(t -> t.getProdId() == id).findFirst().get();
	}

}
