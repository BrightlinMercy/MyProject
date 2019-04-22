package com.thecardcottage.EcomBackend.dao;

import java.util.List;

import com.thecardcottage.EcomBackend.model.Customer;
import com.thecardcottage.EcomBackend.model.MyOrder;


public interface MyOrderDao {
	

	boolean insertMyOrder(MyOrder myorder);
	boolean updateMyOrder(MyOrder myorder);
	boolean deleteMyOrder(String orderid);
	List<MyOrder> selectAllMyOrders(Customer customer);
	MyOrder selectOneMyOrder(String orderid);

}
