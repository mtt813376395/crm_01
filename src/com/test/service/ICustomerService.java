package com.test.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.test.domain.BaseDict;
import com.test.domain.Customer;
import com.test.web.commons.Page;

/**
 * �ͻ���ҵ���ӿ�
 * 
 * @author admin
 *
 */
public interface ICustomerService {
	/**
	 * 
	 * @param dCriteria  ��ѯ����
	 * @param num        ��ǰҳ
	 * @return Page      ��װ�õķ�ҳ��Ϣ
	 */
	Page findAllCustomer(DetachedCriteria dCriteria,Integer num);

	/**
	 * ����ͻ�
	 * 
	 * @param customer
	 */
	void saveCustomer(Customer customer);

	/**
	 * ��ѯ���пͻ���Դ
	 * 
	 * @return
	 */
	List<BaseDict> findAllCustomerSource();

	/**
	 * ��ѯ���пͻ�����
	 * 
	 * @return
	 */
	List<BaseDict> findAllCustomerLevel();

	/**
	 * ɾ���ͻ�
	 * @param customer
	 */
	void removeCutsomer(Customer customer);

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
	List<Customer> findAllCustomer();

}
