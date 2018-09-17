package com.test.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.test.dao.IBaseDictDao;
import com.test.domain.BaseDict;
@Repository("baseDictDao")
public class BaseDictDaoImpl implements IBaseDictDao {
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<BaseDict> findBaseDictByTypeCode(String typeCode) {
		// TODO Auto-generated method stub
		return (List<BaseDict>) hibernateTemplate.find("from BaseDict where dictTypeCode = ?", typeCode);
	}

}
