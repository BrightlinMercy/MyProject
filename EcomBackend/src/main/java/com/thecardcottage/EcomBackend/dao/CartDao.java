package com.thecardcottage.EcomBackend.dao;

import java.util.List;

import com.thecardcottage.EcomBackend.model.Cart;
import com.thecardcottage.EcomBackend.model.Customer;

public interface CartDao {

	boolean insertCart(Cart cart);
	boolean updateCart(Cart cart);
	boolean deleteCart(int itemid);
	List<Cart> selectAllCarts(Customer customer);
	Cart selectOneCart(int itemid);

}
