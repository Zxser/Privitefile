package com.dh.guangfu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.guangfu.po.UserMeter;
import com.dh.guangfu.service.UserMeterService;
import com.dh.guangfu.vo.UserMeterQuery;
import com.dh.system.base.BaseDaoImpl;
import com.dh.utils.PageInfo;
import com.github.pagehelper.PageHelper;
@Service
public class UserMeterServiceImpl extends BaseDaoImpl<UserMeter> implements UserMeterService{

	@Transactional
	public void delete( Long arrayid) {
		super.delete("deleteById", arrayid);
	}
	
	@Override
	public List<UserMeter> fingByUserId(Long userId ) {
		return this.findList("fingByUserId", userId, UserMeter.class);
	}
	
	@Transactional
	@Override
	public void update(UserMeter UserMeter) {
		super.update("update", UserMeter);
	}
	@Transactional
	@Override
	public void save(UserMeter UserMeter) {
		super.update("insert", UserMeter);
	}

	@Override
	public void fingByPage(PageInfo pageInfo, UserMeterQuery userMeterQuery) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize()).setOrderBy("id desc");
		List<UserMeter> findList = this.findList("fingByPage", userMeterQuery, UserMeter.class);
		pageInfo.setList(findList);
		pageInfo.setRecordCount(this.findOne("count", userMeterQuery, Integer.class));
	}

	@Override
	public UserMeter getById(Long id) {
		return this.findOne("getById", id, UserMeter.class);
	}

	@Override
	public void updateAgree(UserMeterQuery userMeterQuery) {
		super.update("updateAgree", userMeterQuery);
	}

}
