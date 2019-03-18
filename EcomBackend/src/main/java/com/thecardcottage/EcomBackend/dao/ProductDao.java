package com.thecardcottage.EcomBackend.dao;

import java.util.List;


public interface ProductDao {
	
	boolean insertProduct(ProductDao product);
	boolean updateProduct(ProductDao product);
	boolean deleteProduct(int pdtid);
	List<ProductDao> selectAllProducts();
	ProductDao selectOneProduct(int pdtid);

}
