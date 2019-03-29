package com.thecardcottage.EcomBackend.dao;

import java.util.List;

import com.thecardcottage.EcomBackend.model.Product;


public interface ProductDao {
	
	boolean insertProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(int pdtid);
	List<Product> selectAllProducts();
	Product selectOneProduct(int pdtid);

}
