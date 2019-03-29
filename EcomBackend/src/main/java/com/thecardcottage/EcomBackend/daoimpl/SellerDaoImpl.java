package com.thecardcottage.EcomBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecardcottage.EcomBackend.dao.SellerDao;
import com.thecardcottage.EcomBackend.model.Seller;
import com.thecardcottage.EcomBackend.model.Usercred;
@Transactional
@Repository
public class SellerDaoImpl implements SellerDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean insertSeller(Seller seller)  {
		try {
			Usercred uc=new Usercred();
			uc.setUername(seller.getSellername());
			uc.setRole("ROLE_SELLER");
			uc.setStatus(false);
		sessionFactory.getCurrentSession().save(seller);
		return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public boolean updateSeller(Seller seller) 
	{
		try {
			sessionFactory.getCurrentSession().update(seller);
			return true;
			}
			catch(Exception e)
			{
			return false;
		}
	}


	@Override
	public boolean deleteSeller(String sellername) {
		try
		{
			sessionFactory.getCurrentSession().delete(selectOneSeller(sellername));
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
		
	}


	@Override
	public List<Seller> selectAllSellers() {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from Seller").list();
			}
		catch(Exception e)
		{
			return null;
		}
		}


	@Override
	public Seller selectOneSeller(String sellername) {
		try
		{
			return (Seller)sessionFactory.getCurrentSession().createQuery("from Seller where sellername='"+sellername+"'").uniqueResult();
		}
		catch(Exception e)
		{
			return null;
		}
		
		}


}
