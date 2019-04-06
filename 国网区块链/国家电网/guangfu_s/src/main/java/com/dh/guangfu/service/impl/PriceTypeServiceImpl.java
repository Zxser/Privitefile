package com.dh.guangfu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.guangfu.po.PriceType;
import com.dh.guangfu.service.PriceTypeService;
import com.dh.guangfu.vo.PriceTypeQuery;
import com.dh.system.base.BaseDaoImpl;
import com.dh.utils.PageInfo;
import com.github.pagehelper.PageHelper;
@Service
public class PriceTypeServiceImpl extends BaseDaoImpl<PriceType> implements PriceTypeService{

	@Transactional
	public void delete( Long arrayid) {
		super.delete("deleteById", arrayid);
	}
	@Override
	public List<PriceType> fingAll() {
		return this.findList("findAll", null, PriceType.class);
	}
	
	@Override
	public PriceType fingById(Long arrayid ) {
		return this.findOne("findById", arrayid, PriceType.class);
	}
	
	@Transactional
	@Override
	public void update(PriceType PriceType) {
		super.update("update", PriceType);
	}
	@Transactional
	@Override
	public void save(PriceType PriceType) {
		super.update("insert", PriceType);
	}
	@Override
	public PageInfo findPage(PageInfo pageInfo, PriceTypeQuery PriceTypeQuery) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize()).setOrderBy("id desc");
		List<PriceType> list=super.findList("findAll", PriceTypeQuery, PriceType.class);
		pageInfo.setList(list);
		Integer count=this.findOne("count", PriceTypeQuery,  Integer.class);
		pageInfo.setRecordCount(count);
		return pageInfo;
	}
}
