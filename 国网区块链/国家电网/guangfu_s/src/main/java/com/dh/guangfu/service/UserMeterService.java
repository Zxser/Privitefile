package com.dh.guangfu.service;

import java.util.List;

import com.dh.guangfu.po.UserMeter;
import com.dh.guangfu.vo.UserMeterQuery;
import com.dh.system.base.BaseDao;
import com.dh.utils.PageInfo;

public interface UserMeterService extends BaseDao{
	
	List<UserMeter> fingByUserId(Long userId);
	
	void update(UserMeter UserMeter);

	void delete(Long arrayid);

	void save(UserMeter UserMeter);

	void fingByPage(PageInfo pageInfo, UserMeterQuery userMeterQuery);

	UserMeter getById(Long id);

	void updateAgree(UserMeterQuery userMeterQuery);
}
