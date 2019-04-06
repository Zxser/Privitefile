package com.dh.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.system.base.BaseDaoImpl;
import com.dh.system.po.SysUserRole;
import com.dh.system.service.SysUserRoleService;

@Service
public class SysUserRoleServiceImpl extends BaseDaoImpl<SysUserRole> implements SysUserRoleService{


	public List<SysUserRole> findBySysUserRole(SysUserRole sys_role_module) {
		return this.findList("findBySysUserRole", sys_role_module, SysUserRole.class);
	}
	@Transactional
	public void deleteByUserId(Long userId) {
		this.delete("deleteByUserId", userId);
	}

	public void save(List<SysUserRole>  list) {
		this.save("insertCodeBatch", list);
	}
	@Override
	public void deleteByRoleId(Long[] arrayid) {
		this.save("deleteByRoleId", arrayid);
	}

	

}
