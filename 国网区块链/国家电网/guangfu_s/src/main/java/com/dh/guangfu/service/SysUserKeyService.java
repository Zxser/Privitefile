package com.dh.guangfu.service;

import com.dh.system.base.BaseDao;
import com.dh.system.po.SysUserKey;

public interface SysUserKeyService extends BaseDao{
	SysUserKey getSysUserKeyById(Long id);

	void save(SysUserKey SysUserKey);

	void update(SysUserKey SysUserKey) throws Exception;

	void delete(Long[] arrayid);

	SysUserKey getByUserId(Long user_id);
}
