package com.thecardcottage.EcomBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecardcottage.EcomBackend.dao.ProductDao;
import com.thecardcottage.EcomBackend.model.Product;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public boolean insertProduct(Product product) {
		try {
		sessionFactory.getCurrentSession().save(product);
		return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
			}
			catch(Exception e)
			{
			return false;
		}
	}

	
	@Override
	public boolean deleteProduct(int pdtid)  {
		try
		{
			sessionFactory.getCurrentSession().delete(selectOneProduct(pdtid));
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	

	@Override
	public List<Product> selectAllProducts() {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from Product").list();
			}
		catch(Exception e)
		{
			return null;
		}
		}
	@Override
	public List<Product> selectCatProducts(int id) {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from Product where pdtcategory="+id).list();
			}
		catch(Exception e)
		{
			return null;
		}
		}

	@Override
	public Product selectOneProduct(int pdtid)  {
		try
		{
			return (Product)sessionFactory.getCurrentSession().createQuery("from Product where pdtid="+pdtid).uniqueResult();
		}
		catch(Exception e)
		{
			return null;
		}
		
		}

}
