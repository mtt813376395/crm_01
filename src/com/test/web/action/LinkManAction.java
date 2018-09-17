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
import com.test.domain.Customer;
import com.test.domain.LinkMan;
import com.test.service.ICustomerService;
import com.test.service.ILinkManService;
/**
 * ��ϵ�˵Ķ�����
 * @author admin
 *
 */
@Controller("linkManAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/linkman")
@Results({
	@Result(name="addUI",type="dispatcher",location="/jsp/linkman/add.jsp"),
	@Result(name="success",type="redirect",location="/jsp/success.jsp"),
	@Result(name="findAllLinkMan",type="dispatcher",location="/jsp/linkman/list.jsp"),
	@Result(name="editUI",type="dispatcher",location="/jsp/linkman/edit.jsp"),
	
})
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan linkman = new LinkMan();
	@Resource(name="customerService")
	private ICustomerService customerService;
	private List<Customer> customers;
	private List<LinkMan> linkmans;
	@Resource(name="linkmanService")
	private ILinkManService linkmanService;
	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkman;
	}
	/**
	 * �༭��ϵ��
	 * @return
	 */
	@Action("editLinkMan")
	public String editLinkMan() {
		linkmanService.updateLinkMan(linkman);
		return SUCCESS;
	}
	/**
	 * ɾ����ϵ��
	 * @return
	 */
	@Action("removeLinkMan")
	public String removeLinkMan() {
		linkmanService.removeLinkMan(linkman.getLkmId());
		return SUCCESS;
	}
	/**
	 * ��ȡ�޸���ϵ��ҳ��
	 * @return
	 */
	@Action("editUILinkMan")
	public String editUILinkMan() {
		//1.����id��ѯ��ϵ����Ϣ����ѯҪ�޸ĵ���ϵ�ˣ�
		LinkMan man = linkmanService.findLinkManById(linkman.getLkmId());
		//2.�Ѳ�ѯ��������ϵ��ѹ��ջ��
		ActionContext.getContext().getValueStack().push(man);
		//3.��ѯ���пͻ���ʹ��ͶӰ��ѯ��
		customers = customerService.findAllCustomer();
		return "editUI";
	}
	/**
	 * ��ѯ��ϵ��
	 * @return
	 */
	@Action("findAllLinkMan")
	public String findAllLinkMan() {
		//1.�������߶���
		DetachedCriteria dCriteria = DetachedCriteria.forClass(LinkMan.class);
		//2.ƴװ��ѯ����
		//�ж��Ƿ���������ϵ������
		if(StringUtils.isNotBlank(linkman.getLkmName())) {
			dCriteria.add(Restrictions.like("lkmName", "%"+linkman.getLkmName() +"%"));
		}
		
		//�ж��Ƿ���������ϵ��ְ��
		if(StringUtils.isNotBlank(linkman.getLkmPosition())) {
			dCriteria.add(Restrictions.like("lkmPosition", "%"+linkman.getLkmPosition() +"%"));
		}
		//�ж��Ƿ�ѡ������ϵ�������ͻ�
		if(linkman.getCustomer()!=null && linkman.getCustomer().getCustId() != null) {
			dCriteria.add(Restrictions.eq("customer", linkman.getCustomer()));
		}
		//�ж��Ƿ�ѡ������ϵ���Ա�
		if(StringUtils.isNotBlank(linkman.getLkmGender())) {
			dCriteria.add(Restrictions.eq("lkmGender",linkman.getLkmGender()));
		}
		//3.��ѯ������ϵ��
		linkmans = linkmanService.findAllLinkMan(dCriteria);
		//4.��ѯ���пͻ���ʹ�ã�
		customers = customerService.findAllCustomer();
		return "findAllLinkMan";
	}
	/**
	 * ������ϵ��
	 * @return
	 */
	@Action("addLinkMan")
	public String addLinkMan() {
		linkmanService.saveLinkMan(linkman);
		return SUCCESS;
	}

	/**
	 * ��ȡ�����ϵ�˽���
	 * @return
	 */
	@Action("addUILinkMan")
	public String addUILinkMan() {
		//1.��ѯ���пͻ�
		customers = customerService.findAllCustomer();
		return "addUI";
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public List<LinkMan> getLinkmans() {
		return linkmans;
	}
	public void setLinkmans(List<LinkMan> linkmans) {
		this.linkmans = linkmans;
	}
	
}
