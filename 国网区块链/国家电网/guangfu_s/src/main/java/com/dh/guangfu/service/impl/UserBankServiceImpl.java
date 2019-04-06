package com.dh.guangfu.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.guangfu.po.UserBank;
import com.dh.guangfu.service.UserBankService;
import com.dh.system.base.BaseDaoImpl;
@Service
public class UserBankServiceImpl extends BaseDaoImpl<UserBank> implements UserBankService{

	@Transactional
	public void delete( Long arrayid) {
		super.delete("deleteById", arrayid);
	}
	
	@Override
	public List<UserBank> fingByUserId(Long userId ) {
		return this.findList("fingByUserId", userId, UserBank.class);
	}
	
	@Transactional
	@Override
	public void update(UserBank UserBank) {
		super.update("update", UserBank);
	}
	@Transactional
	@Override
	public void save(UserBank UserBank) {
		super.save("insert", UserBank);
	}

}
