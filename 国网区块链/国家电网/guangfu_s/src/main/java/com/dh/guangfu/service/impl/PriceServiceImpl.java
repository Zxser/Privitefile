package com.dh.guangfu.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.guangfu.po.Price;
import com.dh.guangfu.service.PriceService;
import com.dh.guangfu.vo.PriceQuery;
import com.dh.system.base.BaseDaoImpl;
import com.dh.utils.PageInfo;
import com.github.pagehelper.PageHelper;
@Service
public class PriceServiceImpl extends BaseDaoImpl<Price> implements PriceService{

	@Transactional
	public void delete( Long arrayid) {
		super.delete("deleteById", arrayid);
	}
	@Override
	public List<Price> fingAll() {
		return this.findList("findAll", null, Price.class);
	}
	
	@Override
	public Price fingById(Long arrayid ) {
		return this.findOne("findById", arrayid, Price.class);
	}
	
	@Transactional
	@Override
	public void update(Price Price) {
		super.update("update", Price);
	}
	@Transactional
	@Override
	public void save(Price Price) {
		Price.setCreate_date(new Date());
		super.update("insert", Price);
	}
	@Override
	public PageInfo findPage(PageInfo pageInfo, PriceQuery PriceQuery) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize()).setOrderBy("id desc");
		List<Price> list=super.findList("findAll", PriceQuery, Price.class);
		pageInfo.setList(list);
		Integer count=this.findOne("count", PriceQuery,  Integer.class);
		pageInfo.setRecordCount(count);
		return pageInfo;
	}

}
