package com.dh.guangfu.service;

import java.util.List;

import com.dh.guangfu.po.PriceType;
import com.dh.guangfu.vo.PriceTypeQuery;
import com.dh.system.base.BaseDao;
import com.dh.utils.PageInfo;

public interface PriceTypeService extends BaseDao{
	List<PriceType> fingAll();
	
	PriceType fingById(Long arrayid);
	
	void update(PriceType PriceType);

	void delete(Long arrayid);

	void save(PriceType PriceType);
	
	PageInfo findPage(PageInfo pageInfo, PriceTypeQuery PriceTypeQuery);
	
}
