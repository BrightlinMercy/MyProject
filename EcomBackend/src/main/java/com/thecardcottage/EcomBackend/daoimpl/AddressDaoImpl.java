package com.thecardcottage.EcomBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.thecardcottage.EcomBackend.dao.AddressDao;
import com.thecardcottage.EcomBackend.model.Address;

@Repository("AddressDao")
@Transactional
public class AddressDaoImpl implements AddressDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean createAddress(Address address) {
		try {
			address.setState("active");
			sessionFactory.getCurrentSession().save(address);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().update(address);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteAddress(Address address) {
		try {
			address.setState("inactive");
			sessionFactory.getCurrentSession().update(address);
			return true;

		} catch (Exception e) {
			return false;
		}
	
	}

	@Override
	public List<Address> selectAllAddress(int custid) {

		try {
			return sessionFactory.getCurrentSession().createQuery("from Address where customer_custid="+custid+"and status='active'").list();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Address selectOneAddress(int addressid) {
	
		try {
			return (Address) sessionFactory.getCurrentSession().createQuery("from Address where addressid=" + addressid).uniqueResult();

		} catch (Exception e) {
			return null;
		}
		
	}

}
