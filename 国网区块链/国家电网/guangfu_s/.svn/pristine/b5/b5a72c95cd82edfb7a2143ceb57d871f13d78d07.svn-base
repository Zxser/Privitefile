package com.dh.guangfu.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.guangfu.service.SysUserKeyService;
import com.dh.system.base.BaseDaoImpl;
import com.dh.system.po.SysUserKey;

@Service
public class SysUserKeyServiceImpl extends BaseDaoImpl<SysUserKey>  implements SysUserKeyService{
	
	@Override
	public SysUserKey getSysUserKeyById(Long id) {
		SysUserKey selectByPrimaryKey =this.findOne("findById", id, SysUserKey.class);
		return selectByPrimaryKey;
	}

	@Transactional
	public void save(SysUserKey SysUserKey) {
		super.save("insert",SysUserKey);
	}
	@Transactional
	public void update(SysUserKey SysUserKey) throws Exception {
		super.update("update", SysUserKey);
	}
	
	@Transactional
	public void delete(Long[] arrayid) {
		 super.delete("deleteById",arrayid);
	}

	@Override
	public SysUserKey getByUserId(Long user_id) {
		SysUserKey SysUserKey = this.findOne("getByUserId",user_id, SysUserKey.class);
		return SysUserKey;
	}
}
