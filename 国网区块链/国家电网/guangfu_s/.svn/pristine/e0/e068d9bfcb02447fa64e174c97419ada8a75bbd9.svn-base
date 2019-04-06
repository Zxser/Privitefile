package com.dh.guangfu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dh.guangfu.po.CmsInfo;
import com.dh.guangfu.service.CmsInfoService;
import com.dh.guangfu.vo.CmsInfoQuery;
import com.dh.system.base.BaseDaoImpl;
import com.dh.utils.PageInfo;
import com.github.pagehelper.PageHelper;
@Service
public class CmsInfoServiceImpl extends BaseDaoImpl<CmsInfo> implements CmsInfoService{
	
	@Override
	public List<CmsInfo> findAll() {
		return this.findList("findAll", null, CmsInfo.class);
	}

	@Override
	public List<CmsInfo> findById(Long[] arrayid) {
		return this.findList("selectById", arrayid, CmsInfo.class);
	}

	@Override
	public void update(CmsInfo cmsInfo) {
		this.update("updateById", cmsInfo);
	}

	@Override
	public void delete(Long[] arrayid) {
		super.delete("deleteById", arrayid);
	}

	@Override
	public void deleteByCmsTypeId(Long[] arrayid) {
		super.delete("deleteByCmsTypeId", arrayid);
	}

	@Override
	public void save(CmsInfo cmsInfo) {
		super.update("insert",cmsInfo);
		
	}

	@Override
	public PageInfo findPage(PageInfo pageInfo, CmsInfoQuery cmsInfoQuery) {
	
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize()).setOrderBy("id desc");
		List<CmsInfoQuery> 	findList = this.findList("findAll", cmsInfoQuery,CmsInfoQuery.class);		
		pageInfo.setList(findList);
		Integer count = this.findOne("count", cmsInfoQuery,Integer.class);
		pageInfo.setRecordCount(count);
		return pageInfo;
	}

	@Override
	public CmsInfo findById(Long arrayid) {
		return this.findOne("findById", arrayid, CmsInfo.class);
	}

	}
