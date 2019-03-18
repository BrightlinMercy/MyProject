package com.thecardcottage.EcomBackend.dao;

import java.util.List;


import com.thecardcottage.EcomBackend.model.Customer;

public interface CustomerDao {
	
	boolean insertCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer(String custemailid);
	List<Customer> selectAllCustomers();
	Customer selectOneCustomer(String custemailid);
	
	
	
}