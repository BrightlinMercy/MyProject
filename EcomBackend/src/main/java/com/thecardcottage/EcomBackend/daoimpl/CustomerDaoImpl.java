package com.thecardcottage.EcomBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecardcottage.EcomBackend.dao.CustomerDao;
import com.thecardcottage.EcomBackend.model.Customer;
import com.thecardcottage.EcomBackend.model.Usercred;
@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean insertCustomer(Customer customer) {
		try {
			Usercred uc=new Usercred();
			uc.setUername(customer.getCustemailid());
			uc.setPassword(customer.getCustpassword());
			uc.setRole("ROLE_CUSTOMER");
			uc.setStatus(false);
		sessionFactory.getCurrentSession().save(customer);
		return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}
	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			sessionFactory.getCurrentSession().update(customer);
			return true;
			}
			catch(Exception e)
			{
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(String custemailid) {
		try
		{
			sessionFactory.getCurrentSession().delete(custemailid,Customer.class);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public List<Customer> selectAllCustomers() {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from Customer").list();
			}
		catch(Exception e)
		{
			return null;
		}
		}

	@Override
	public Customer selectOneCustomer(String custemailid) {
	try
	{
		return (Customer) sessionFactory.getCurrentSession().createQuery("from customer while email id='"+custemailid+"'").uniqueResult();
	}
	catch(Exception e)
	{
		return null;
	}
	
	}

}
