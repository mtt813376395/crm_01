package com.test.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.test.domain.LinkMan;
/**
 * ��ϵ�˵�ҵ���ӿ�
 * @author admin
 *
 */
public interface ILinkManService {
	/**
	 * ������ϵ��
	 * @param linkman
	 */
	void saveLinkMan(LinkMan linkman);
	
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
	void removeLinkMan(Long lkmId);

	/**
	 * ����id��ѯ��ϵ��
	 * @param lkmId
	 * @return
	 */
	LinkMan findLinkManById(Long lkmId);

	/**
	 * ������ϵ��
	 * @param linkman
	 */
	void updateLinkMan(LinkMan linkman);

	

}
