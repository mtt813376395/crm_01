package com.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.test.dao.ILinkManDao;
import com.test.domain.LinkMan;
@Repository("linkmanDao")
public class LinkManDaoImpl implements ILinkManDao {
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void save(LinkMan linkman) {
		hibernateTemplate.save(linkman);

	}

	@Override
	public List<LinkMan> findAllLinkMan(DetachedCriteria dCriteria) {
		return (List<LinkMan>) hibernateTemplate.findByCriteria(dCriteria);
	}

	@Override
	public void delete(Long lkmId) {
		hibernateTemplate.delete(findById(lkmId));
		
	}


	@Override
	public LinkMan findById(Long lkmId) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(LinkMan.class, lkmId);
	}

	@Override
	public void update(LinkMan linkman) {
		hibernateTemplate.update(linkman);
		
	}

}
