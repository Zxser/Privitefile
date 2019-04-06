package com.dh.guangfu.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.guangfu.po.UserTotal;
import com.dh.guangfu.service.UserTotalService;
import com.dh.system.base.BaseDaoImpl;
@Service
public class UserTotalServiceImpl extends BaseDaoImpl<UserTotal> implements UserTotalService{

	@Transactional
	public void delete( Long arrayid) {
		super.delete("deleteById", arrayid);
	}
	
	@Override
	public UserTotal fingByUserId(Long userId ) {
		return this.findOne("fingByUserId", userId, UserTotal.class);
	}
	
	@Transactional
	@Override
	public void update(UserTotal UserTotal) {
		super.update("update", UserTotal);
	}
	@Transactional
	@Override
	public void save(UserTotal UserTotal) {
		super.update("insert", UserTotal);
	}

}
