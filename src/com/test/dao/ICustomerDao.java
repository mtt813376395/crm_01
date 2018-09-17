package com.test.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.test.domain.BaseDict;
import com.test.domain.Customer;

/**
 * �ͻ��ĳ־ò�ӿ�
 * 
 * @author admin
 *
 */
public interface ICustomerDao {
	/**
	 * ��ѯ�ܼ�¼����
	 * @param dCriteria  ��ѯ������
	 * @return
	 */
	int findTotalRecords(DetachedCriteria dCriteria);

	/**
	 * ��ѯ�ͻ��б�
	 * @param dCriteria   ��ѯ������
	 * @param firstResult  ��ѯ�Ŀ�ʼ��¼����
	 * @param maxResults   ÿ�β�ѯ��¼������
	 * @return
	 */
	List<Customer> findAll(DetachedCriteria dCriteria,int firstResult,int maxResults);

	/**
	 * ����ͻ�
	 * 
	 * @param customer
	 */
	void save(Customer customer);

	/**
	 * ɾ���ͻ�
	 * 
	 * @param customer
	 * @return
	 */
	void deleteCustomer(Customer customer);

	/**
	 * ����id��ѯ�ͻ�
	 * @param custId
	 * @return
	 */
	Customer findCustomerById(Long custId);

	/**
	 * ���¿ͻ�
	 * @param customer
	 */
	void updateCustomer(Customer customer);

	/**
	 * ʹ��ͶӰ��ѯ�ͻ��б�
	 * @return
	 */
	List<Customer> findAll();

}
