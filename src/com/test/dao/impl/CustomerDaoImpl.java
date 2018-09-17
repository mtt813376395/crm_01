package com.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.test.dao.ICustomerDao;
import com.test.domain.Customer;

import javassist.bytecode.annotation.IntegerMemberValue;

/**
 * 客户的持久层实现类
 * 
 * @author admin
 *
 */
@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {
	@Resource(name = "hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void save(Customer customer) {
		hibernateTemplate.save(customer);

	}

	@Override
	public void deleteCustomer(Customer customer) {
		hibernateTemplate.delete(customer);
	}

	@Override
	public Customer findCustomerById(Long custId) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Customer.class, custId);
	}

	@Override
	public void updateCustomer(Customer customer) {
		hibernateTemplate.update(customer);

	}

	@Override
	public List<Customer> findAll() {

		return (List<Customer>) hibernateTemplate.find("select new Customer(custId,custName) from Customer");
	}

	@Override
	public int findTotalRecords(DetachedCriteria dCriteria) {
		dCriteria.setProjection(Projections.count("custId"));
		List<Long> list = (List<Long>) hibernateTemplate.findByCriteria(dCriteria);
		return list.isEmpty() ? 0 : list.get(0).intValue();
	}

	@Override
	public List<Customer> findAll(DetachedCriteria dCriteria, int firstResult, int maxResults) {
		dCriteria.setProjection(null);
		
		return (List<Customer>) hibernateTemplate.findByCriteria(dCriteria, firstResult, maxResults);
	}

}
