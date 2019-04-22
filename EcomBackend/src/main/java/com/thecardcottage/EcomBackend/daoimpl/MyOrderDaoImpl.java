package com.thecardcottage.EcomBackend.daoimpl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecardcottage.EcomBackend.dao.MyOrderDao;
import com.thecardcottage.EcomBackend.model.Customer;
import com.thecardcottage.EcomBackend.model.MyOrder;

@Transactional
@Repository
public class MyOrderDaoImpl implements MyOrderDao {
	
	@Autowired
	SessionFactory sessionFactory;


	@Override
	public boolean insertMyOrder(MyOrder myorder) {
		try {
		sessionFactory.getCurrentSession().save(myorder);
		return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}
	@Override
	public boolean updateMyOrder(MyOrder myorder)  {
		try {
			sessionFactory.getCurrentSession().update(myorder);
			return true;
			}
			catch(Exception e)
			{
			return false;
		}
	}
	@Override
	public boolean deleteMyOrder(String orderid) {
		try
		{
			sessionFactory.getCurrentSession().delete(selectOneMyOrder(orderid));
			
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
		
	}


	@Override
	public List<MyOrder> selectAllMyOrders(Customer customer) {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from MyOrder where customer="+customer.getCustid()).list();
			}
		catch(Exception e)
		{
			return null;
		}
		}

	@Override
	public MyOrder selectOneMyOrder(String orderid) {
		try
		{
			return (MyOrder) sessionFactory.getCurrentSession().createQuery("from MyOrder where orderid='"+orderid+"'").uniqueResult();
		}
		catch(Exception e)
		{
			return null;
		}
		
		}


}
