package com.test.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.test.domain.BaseDict;
import com.test.domain.Customer;
import com.test.web.commons.Page;

/**
 * 客户的业务层接口
 * 
 * @author admin
 *
 */
public interface ICustomerService {
	/**
	 * 
	 * @param dCriteria  查询条件
	 * @param num        当前页
	 * @return Page      封装好的分页信息
	 */
	Page findAllCustomer(DetachedCriteria dCriteria,Integer num);

	/**
	 * 保存客户
	 * 
	 * @param customer
	 */
	void saveCustomer(Customer customer);

	/**
	 * 查询所有客户来源
	 * 
	 * @return
	 */
	List<BaseDict> findAllCustomerSource();

	/**
	 * 查询所有客户级别
	 * 
	 * @return
	 */
	List<BaseDict> findAllCustomerLevel();

	/**
	 * 删除客户
	 * @param customer
	 */
	void removeCutsomer(Customer customer);

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
	List<Customer> findAllCustomer();

}
