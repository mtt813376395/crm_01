package com.test.dao;

import java.util.List;

import com.test.domain.BaseDict;

public interface IBaseDictDao {

	List<BaseDict> findBaseDictByTypeCode(String typeCode);

}
