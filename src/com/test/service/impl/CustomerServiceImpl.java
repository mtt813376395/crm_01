package com.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.IBaseDictDao;
import com.test.dao.ICustomerDao;
import com.test.domain.BaseDict;
import com.test.domain.Customer;
import com.test.service.ICustomerService;
import com.test.web.commons.Page;

/**
 * �ͻ���ҵ���ʵ����
 * 
 * @author admin
 *
 */
@Service("customerService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class CustomerServiceImpl implements ICustomerService {
	@Resource(name = "customerDao")
	private ICustomerDao customerDao;
	@Resource(name = "baseDictDao")
	private IBaseDictDao baseDictDao;

	

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);

	}

	@Override
	public List<BaseDict> findAllCustomerSource() {

		return baseDictDao.findBaseDictByTypeCode("002");
	}

	@Override
	public List<BaseDict> findAllCustomerLevel() {

		return baseDictDao.findBaseDictByTypeCode("006");
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void removeCutsomer(Customer customer) {
		
		customerDao.deleteCustomer(customer);
		
	}

	@Override
	public Customer findCustomerById(Long custId) {
		return customerDao.findCustomerById(custId);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		
	}

	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	@Override
	public Page findAllCustomer(DetachedCriteria dCriteria, Integer num) {
		//1.׼����ǰҳ����
		int currentPageNum = 1;
		if(num != null) {
			currentPageNum = num;
		}
		//2.��ȡ�ܼ�¼����
		int totalRecords = customerDao.findTotalRecords(dCriteria);
		//3.����һ��page����
		Page page = new Page(currentPageNum,totalRecords);
		//4.ʹ��page�����е����ݣ���ѯ���з�ҳ�еĽ����
		List<Customer> records = customerDao.findAll(dCriteria,page.getStartIndex(),page.getPageSize());
		//5.�Ѳ�ѯ�����Ľ������װ��page������
		page.setRecords(records);;
		//6.����page����
		return page;
	}

}
