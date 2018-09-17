package com.test.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.test.domain.BaseDict;
import com.test.domain.Customer;

/**
 * 客户的持久层接口
 * 
 * @author admin
 *
 */
public interface ICustomerDao {
	/**
	 * 查询总记录条数
	 * @param dCriteria  查询的条件
	 * @return
	 */
	int findTotalRecords(DetachedCriteria dCriteria);

	/**
	 * 查询客户列表
	 * @param dCriteria   查询的条件
	 * @param firstResult  查询的开始记录索引
	 * @param maxResults   每次查询记录的条数
	 * @return
	 */
	List<Customer> findAll(DetachedCriteria dCriteria,int firstResult,int maxResults);

	/**
	 * 保存客户
	 * 
	 * @param customer
	 */
	void save(Customer customer);

	/**
	 * 删除客户
	 * 
	 * @param customer
	 * @return
	 */
	void deleteCustomer(Customer customer);

	/**
	 * 根据id查询客户
	 * @param custId
	 * @return
	 */
	Customer findCustomerById(Long custId);

	/**
	 * 更新客户
	 * @param customer
	 */
	void updateCustomer(Customer customer);

	/**
	 * 使用投影查询客户列表
	 * @return
	 */
	List<Customer> findAll();

}
