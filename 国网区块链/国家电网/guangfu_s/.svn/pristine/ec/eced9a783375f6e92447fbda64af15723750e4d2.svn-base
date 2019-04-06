package com.dh.system.service;

import com.dh.system.base.BaseDao;
import com.dh.system.po.SysUserManage;
import com.dh.system.vo.SysUserManageQuery;
import com.dh.utils.PageInfo;

public interface SysUserManageService extends BaseDao{
	SysUserManage getSysUserManageById(Long id);

	SysUserManage getUserByName(String username);

	void save(SysUserManage SysUserManage);

	void update(SysUserManage SysUserManage) throws Exception;

	void fingAll(PageInfo pageInfo,SysUserManageQuery SysUserManage);

	void delete(Long arrayid);

	SysUserManage getById(Long id);

	SysUserManage getUserByPhone(String phone);

}
