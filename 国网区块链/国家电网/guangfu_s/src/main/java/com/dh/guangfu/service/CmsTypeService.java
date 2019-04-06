package com.dh.guangfu.service;

import java.util.List;

import com.dh.guangfu.po.CmsType;
import com.dh.guangfu.vo.CmsTypeQuery;
import com.dh.system.base.BaseDao;
import com.dh.utils.PageInfo;

public interface CmsTypeService extends BaseDao{
	List<CmsType> fingAll();
	
	CmsType fingById(Long arrayid);
	
	void update(CmsType cmsType);

	void delete(Long arrayid);

	void save(CmsType cmsType);
	
	PageInfo findPage(PageInfo pageInfo, CmsTypeQuery cmsTypeQuery);
	
}
