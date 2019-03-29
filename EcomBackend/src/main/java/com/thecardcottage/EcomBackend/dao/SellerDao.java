package com.thecardcottage.EcomBackend.dao;

import java.util.List;


import com.thecardcottage.EcomBackend.model.Seller;


public interface SellerDao {
	
	boolean insertSeller(Seller seller);
	boolean updateSeller(Seller seller);
	boolean deleteSeller(String sellername);
	List<Seller> selectAllSellers();
	Seller selectOneSeller(String sellername);

}
