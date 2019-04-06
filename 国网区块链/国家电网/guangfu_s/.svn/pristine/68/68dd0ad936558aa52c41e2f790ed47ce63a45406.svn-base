package com.dh.guangfu.service;

import java.util.List;

import com.dh.guangfu.po.CmsInfo;
import com.dh.guangfu.vo.CmsInfoQuery;
import com.dh.system.base.BaseDao;
import com.dh.utils.PageInfo;
/**
 * cms文章内容管理
 * @author tianjiao
 *
 */
public interface CmsInfoService extends BaseDao{
	
	List<CmsInfo> findAll();
	
	CmsInfo findById(Long id);
	
	List<CmsInfo> findById(Long[] arrayid);
	
	void update(CmsInfo cmsInfo);

	void delete(Long[] arrayid);
	
	void deleteByCmsTypeId(Long[] arrayid);

	void save(CmsInfo cmsInfo);
	
	PageInfo findPage(PageInfo pageInfo, CmsInfoQuery cmsInfoQuery);
	
}
