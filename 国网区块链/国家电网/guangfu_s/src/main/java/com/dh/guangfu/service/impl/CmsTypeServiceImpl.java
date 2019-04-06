package com.dh.guangfu.service.impl;

import java.util.Dictionary;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.guangfu.po.CmsType;
import com.dh.guangfu.service.CmsTypeService;
import com.dh.guangfu.vo.CmsTypeQuery;
import com.dh.system.base.BaseDaoImpl;
import com.dh.utils.PageInfo;
import com.github.pagehelper.PageHelper;
@Service
public class CmsTypeServiceImpl extends BaseDaoImpl<CmsType> implements CmsTypeService{

	@Transactional
	public void updateType(CmsType CmsType) {
		this.update("update", CmsType);
	}
	@Transactional
	public void delete( Long arrayid) {
		super.delete("deleteById", arrayid);
	}
	@Override
	public List<CmsType> fingAll() {
		return this.findList("findAll", null, CmsType.class);
	}
	
	@Override
	public CmsType fingById(Long arrayid ) {
		return this.findOne("findById", arrayid, CmsType.class);
	}
	
	@Transactional
	@Override
	public void update(CmsType CmsType) {
		super.update("update", CmsType);
	}
	@Transactional
	@Override
	public void save(CmsType CmsType) {
		super.update("insert", CmsType);
	}
	@Override
	public PageInfo findPage(PageInfo pageInfo, CmsTypeQuery CmsTypeQuery) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize()).setOrderBy("id desc");
		List<Dictionary> list=super.findList("findAll", CmsTypeQuery, Dictionary.class);
		pageInfo.setList(list);
		Integer count=this.findOne("count", CmsTypeQuery,  Integer.class);
		pageInfo.setRecordCount(count);
		return pageInfo;
	}

}
