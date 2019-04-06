package com.dh.system.service;

import java.util.List;

import com.dh.system.base.BaseDao;
import com.dh.system.po.SysUserRole;

public interface SysUserRoleService  extends BaseDao{
	void save(List<SysUserRole> list);
	void deleteByUserId(Long userId);
	List<SysUserRole> findBySysUserRole(SysUserRole sys_role_module);
	void deleteByRoleId(Long[] arrayid);
}
