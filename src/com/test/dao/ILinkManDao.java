package com.test.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.test.domain.LinkMan;
/**
 * ��ϵ�˵ĳ־ò�ӿ�
 * @author admin
 *
 */
public interface ILinkManDao {

	/**
	 * ������ϵ��
	 * @param linkman
	 */
	void save(LinkMan linkman);

	/**
	 * ��ѯ������ϵ��
	 * @param dCriteria
	 * @return
	 */
	List<LinkMan> findAllLinkMan(DetachedCriteria dCriteria);

	/**
	 * ɾ����ϵ��
	 * @param lkmId
	 */
	void delete(Long lkmId);
	
	/**
	 * ����id��ѯ��ϵ��
	 * @param linkman
	 */
	LinkMan findById(Long lkmId);

	/**
	 * ������ϵ��
	 * @param linkman
	 */
	void update(LinkMan linkman);

}
