package com.dh.system.service;

import java.util.List;

import com.dh.system.base.BaseDao;
import com.dh.system.po.SysRole;
import com.dh.system.vo.SysRoleQuery;
import com.dh.utils.PageInfo;
/**
 * 角色管理
 * @author liliangliang
 *
 */
public interface SysRoleService  extends BaseDao{
	SysRole getSysRoleById(Long id);
	List<SysRole> fingAll();
	void updateRole(SysRole sysRole);
	void fingAll(PageInfo pageInfo, SysRoleQuery sysRole);
	void delete(Long[] arrayid);
}
