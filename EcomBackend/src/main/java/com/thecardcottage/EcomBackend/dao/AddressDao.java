package com.thecardcottage.EcomBackend.dao;

import java.util.List;

import com.thecardcottage.EcomBackend.model.Address;


public interface AddressDao {
	
	boolean createAddress(Address address);

	boolean updateAddress(Address address);

	boolean deleteAddress(Address address);

	List<Address> selectAllAddress(int custid);

	Address selectOneAddress(int addressid);

}
