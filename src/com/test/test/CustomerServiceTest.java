package com.test.test;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.domain.Customer;
import com.test.service.ICustomerService;

/**
 * 测试客户的业务层方法
 * 
 * @author admin
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/applicationContext.xml" })
public class CustomerServiceTest {

	@Autowired
	private ICustomerService cs;

	@Test
	public void testFindAll() {
//		DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class);
//		List list = cs.findAllCustomer(dCriteria);
//		for (Object o : list) {
//			System.out.println(o);
//		}
	}
	
	@Test
	public void testSave() {
		Customer c = new Customer();
		c.setCustName("qwe");
		cs.saveCustomer(c);
		
	}

}
