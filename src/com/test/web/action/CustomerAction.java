package com.test.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.test.domain.BaseDict;
import com.test.domain.Customer;
import com.test.service.ICustomerService;
import com.test.web.commons.Page;

/**
 * �ͻ��Ķ�����
 * 
 * @author admin
 *
 */
@Controller("customerAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/customer")
@Results({ @Result(name = "addUI", type = "dispatcher", location = "/jsp/customer/add.jsp"),
		@Result(name = "findAll", type = "dispatcher", location = "/jsp/customer/list.jsp"),
		@Result(name = "listCustomer", type = "redirectAction", location = "findAllCustomer"),
		@Result(name = "removeCustomer", type = "redirectAction", location = "findAllCustomer"),
		@Result(name = "editUICustomer", type = "dispatcher", location = "/jsp/customer/edit.jsp"),
		@Result(name = "editCustomer", type = "redirectAction", location = "findAllCustomer") })
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();

	private List<BaseDict> custSources;
	private List<BaseDict> custLevels;
	private Page page;
	private Integer num;
	@Resource(name = "customerService")
	private ICustomerService customerService;

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	/**
	 * ���¿ͻ�
	 * 
	 * @return
	 */
	@Action("editCustomer")
	public String editCustomer() {
		customerService.updateCustomer(customer);
		return "editCustomer";
	}

	@Action("editUICustomer")
	public String editUICustomer() {
		// 1.����id��ѯҪ�༭�Ŀͻ�����
		Customer c = customerService.findCustomerById(customer.getCustId());
		// 2.��ȡֵջ����
		ValueStack vs = ActionContext.getContext().getValueStack();
		// 3.�Ѳ�ѯ�ĳ����Ŀͻ�����ѹ��ջ��
		vs.push(c);
		// 4.��ѯ���пͻ���Դ�Ϳͻ�����
		custSources = customerService.findAllCustomerSource();
		custLevels = customerService.findAllCustomerLevel();
		return "editUICustomer";
	}

	/**
	 * ɾ���ͻ�
	 * 
	 * @return
	 */
	@Action("removeCustomer")
	public String removeCustomer() {
		customerService.removeCutsomer(customer);
		return "removeCustomer";
	}

	/**
	 * �����ͻ�
	 * 
	 * @return
	 */
	@Action("addCustomer")
	public String addCustomer() {
		customerService.saveCustomer(customer);
		return "listCustomer";
	}

	/**
	 * ��ѯ�ͻ��б�
	 */
	@Action("findAllCustomer")
	public String findAllCustomer() {
		// 1.�������߶���
		DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class);
		// 2.ƴװ��ѯ����
		// �ж��Ƿ������˿ͻ�����
		if (StringUtils.isNotBlank(customer.getCustName())) {
			// ģ����ѯ�ͻ�����
			dCriteria.add(Restrictions.like("custName", "%" + customer.getCustName() + "%"));
		}
		// �ж��Ƿ������˿ͻ���ҵ
		if (StringUtils.isNotBlank(customer.getCustIndustry())) {
			// ģ����ѯ�ͻ���ҵ
			dCriteria.add(Restrictions.like("custIndustry", "%" + customer.getCustIndustry() + "%"));
		}
		// �ж��Ƿ�ѡ���˿ͻ�����
		if (customer.getCustLevel() != null && StringUtils.isNotBlank(customer.getCustLevel().getDictId())) {
			// ��ȷ��ѯ�ͻ�����
			dCriteria.add(Restrictions.eq("custLevel.dictId", customer.getCustLevel().getDictId()));
		}
		// �ж��Ƿ�ѡ���˿ͻ���Դ
		if (customer.getCustSource() != null && StringUtils.isNotBlank(customer.getCustSource().getDictId())) {
			// ��ȷ��ѯ�ͻ�����
			dCriteria.add(Restrictions.eq("custSource.dictId", customer.getCustSource().getDictId()));
		}

		// 3.�������߶����ѯ�ͻ���Ϣ
		page = customerService.findAllCustomer(dCriteria, num);
		// 4.��ѯ���пͻ���Դ
		custSources = customerService.findAllCustomerSource();
		// 5.��ѯ���пͻ�����
		custLevels = customerService.findAllCustomerLevel();
		return "findAll";
	}

	/**
	 * ��ȡ��ӿͻ�ҳ��
	 * 
	 * @return
	 */
	@Action("addUICustomer")
	public String addUICustomer() {

		// 1.��ѯ���пͻ���Դ
		custSources = customerService.findAllCustomerSource();
		// 2.��ѯ���пͻ�����
		custLevels = customerService.findAllCustomerLevel();
		return "addUI";
	}

	public List<BaseDict> getCustSources() {
		return custSources;
	}

	public void setCustSources(List<BaseDict> custSources) {
		this.custSources = custSources;
	}

	public List<BaseDict> getCustLevels() {
		return custLevels;
	}

	public void setCustLevels(List<BaseDict> custLevels) {
		this.custLevels = custLevels;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
