package com.dh.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.system.base.BaseDaoImpl;
import com.dh.system.po.SysRole;
import com.dh.system.po.SysRoleModule;
import com.dh.system.service.SysRoleModuleService;
import com.dh.system.service.SysRoleService;
import com.dh.system.service.SysUserRoleService;
import com.dh.system.vo.SysRoleQuery;
import com.dh.utils.PageInfo;
import com.github.pagehelper.PageHelper;
@Service
public class SysRoleServiceImpl extends BaseDaoImpl<SysRole> implements SysRoleService {
	
	@Autowired
	private SysRoleModuleService sysRoleModuleService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	 
	public SysRole getSysRoleById(Long id) {
		SysRole selectByPrimaryKey =this.findOne("findById", id, SysRole.class);
		return  selectByPrimaryKey;
	}

	 
	public void fingAll(PageInfo pageInfo, SysRoleQuery sysRoleQuery) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize()).setOrderBy("id desc");
		List<SysRole> findList = this.findList("findAll", sysRoleQuery,SysRole.class);
		Integer i =this.findOne("count", sysRoleQuery,Integer.class);
		pageInfo.setList(findList);
		pageInfo.setPage(i, pageInfo.getPageSize());
	}
	@Transactional
	public void updateRole(SysRole sysRole) {
		super.update("update", sysRole);
		sysRoleModuleService.deleteNotRole(sysRole.getId());//删除不关联的模块信息
		Long[] id=sysRole.getModuleId();
		List<SysRoleModule> list=new ArrayList<SysRoleModule>();
		if(null!=id&&id.length>0){
			for (Long long1 : id) {
				SysRoleModule sys_role_module=new SysRoleModule();
				sys_role_module.setModuleId(long1);
				sys_role_module.setRoleId(sysRole.getId());
				list.add(sys_role_module);
			}
			sysRoleModuleService.insert(list);
		}
	}

	@Transactional
	public void delete( Long[] arrayid) {
		sysRoleModuleService.deleteByRoleId(arrayid);//删除关联的模块信息
		sysUserRoleService.deleteByRoleId(arrayid);//删除关联的用户信息		
		super.delete("deleteById", arrayid);
	}
	@Override
	public List<SysRole> fingAll() {
		return this.findList("findAll", null, SysRole.class);
	}

}
