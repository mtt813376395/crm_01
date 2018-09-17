package com.test.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * �ͻ���ʵ����
 * 
 * @author admin
 *
 */
@Entity
@Table(name = "cst_customer")
public class Customer implements Serializable {
	@Id
	@Column(name = "cust_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custId;
	@Column(name = "cust_name")
	private String custName;
	@Column(name = "cust_industry")
	private String custIndustry;
	@Column(name = "cust_address")
	private String custAddress;
	@Column(name = "cust_phone")
	private String custPhone;

	@ManyToOne(targetEntity = BaseDict.class)
	@JoinColumn(name = "cust_source", referencedColumnName = "dict_id")
	private BaseDict custSource;

	@ManyToOne(targetEntity = BaseDict.class)
	@JoinColumn(name = "cust_level", referencedColumnName = "dict_id")
	private BaseDict custLevel;
	//һ�Զ��ϵӳ�䣺һ���ͻ����Զ�Ӧ�����ϵ��
	@OneToMany(mappedBy="customer")
	private Set<LinkMan> linkMans = new HashSet<LinkMan>(0);

	public Customer() {
		
	}
	public Customer(Long custId, String custName) {
		this.custId = custId;
		this.custName = custName;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String getCustIndustry() {
		return custIndustry;
	}

	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}


	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public BaseDict getCustSource() {
		return custSource;
	}

	public void setCustSource(BaseDict custSource) {
		this.custSource = custSource;
	}

	public BaseDict getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(BaseDict custLevel) {
		this.custLevel = custLevel;
	}

	
	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}

	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custIndustry=" + custIndustry
				+ ", custAddress=" + custAddress + ", custPhone=" + custPhone + "]";
	}

	
}
