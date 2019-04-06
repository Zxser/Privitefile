package com.dh.system.service;

import java.util.List;

import com.dh.system.po.SysModule;
import com.dh.system.po.SysRoleModule;

public interface SysRoleModuleService {
	List<SysRoleModule> getSysModuleById(Long id);
	/**
	 * 根据角色id查询权限模块
	 * @param roleId
	 * @return
	 */
	void deleteNotRole(Long long1);
	List<SysRoleModule> getbyRoleId(Long id);
	void insert(List<SysRoleModule> list);
	void deleteByRoleId(Long[] arrayid);
	void save(SysRoleModule sysRoleModule);
	List<SysModule> getbyPId(SysRoleModule sysRoleModule);
	void saveModules(SysRoleModule sysRoleModule);
}
