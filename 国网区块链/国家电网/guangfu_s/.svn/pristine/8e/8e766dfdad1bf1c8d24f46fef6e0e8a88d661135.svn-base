package com.dh.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.system.base.BaseDaoImpl;
import com.dh.system.po.SysModule;
import com.dh.system.po.SysRoleModule;
import com.dh.system.service.SysRoleModuleService;
import com.dh.system.vo.Children;
import com.dh.system.vo.JSONModule;
@Service
public class SysRoleModuleServiceImpl extends BaseDaoImpl<SysRoleModule> implements SysRoleModuleService{
	@Autowired
	SysRoleModuleService sysRoleModuleService;
	
	@Transactional
	@Override
	public void deleteNotRole(Long longs) {
		this.delete("deleteNotRole", longs);
	}

	@Override
	public List<SysRoleModule> getbyRoleId(Long id) {
		return this.findList("findbyRoleId", id, SysRoleModule.class);
	}
	@Transactional
	public void insert(List<SysRoleModule> list) {
		this.save("insertCodeBatch", list);
	}

	@Override
	public List<SysRoleModule> getSysModuleById(Long id) {
		 return this.findList("findbyModuleId", id, SysRoleModule.class);
	}

	@Override
	public void deleteByRoleId(Long[] arrayid) {
		this.save("deleteByRoleId", arrayid);
	}

	@Override
	public void save(SysRoleModule sysRoleModule) {
	//	sysRoleModuleService.deleteNotRole(sysRoleModule.getRoleId());//删除不关联的模块信息
		JSONModule[] JSONModule=sysRoleModule.getJSONModule();
		List <SysRoleModule> list=new ArrayList<SysRoleModule>();
		for (JSONModule json : JSONModule) {
			Children[] child=json.getChildren();
			if(null!=child&&child.length>0){
				for (Children ch : child) {
					SysRoleModule rolemodule=new SysRoleModule();
					rolemodule.setRoleId(sysRoleModule.getRoleId());
					rolemodule.setModuleId(ch.getId());
					rolemodule.setPid(ch.getPid());
					list.add(rolemodule);
				}
			}else{
				SysRoleModule rolemodule=new SysRoleModule();
				rolemodule.setRoleId(sysRoleModule.getRoleId());
				rolemodule.setModuleId(json.getId());
				list.add(rolemodule);
			}
		}
		this.insert(list);
	}

	@Override
	public List<SysModule> getbyPId(SysRoleModule sysRoleModule) {
		 return this.findList("getbyPId", sysRoleModule, SysModule.class);
	}

	@Override
	public void saveModules(SysRoleModule sysModule) {
		sysRoleModuleService.deleteNotRole(sysModule.getRoleId());//删除不关联的模块信息
		List <SysRoleModule> list=new ArrayList<SysRoleModule>();
		for (SysModule module : sysModule.getSysModule()) {
			List<SysModule> children = module.getChildren();
			if(null!=children&&children.size()>0){
				for (SysModule ch : children) {
					SysRoleModule rolemodule=new SysRoleModule();
					rolemodule.setRoleId(sysModule.getRoleId());
					rolemodule.setModuleId(ch.getId());
					rolemodule.setPid(module.getId());
					rolemodule.setSort(ch.getSort());
					list.add(rolemodule);
				}
			}
			
			SysRoleModule rolemodule=new SysRoleModule();
			rolemodule.setRoleId(sysModule.getRoleId());
			rolemodule.setModuleId(module.getId());
			rolemodule.setSort(module.getSort());
			list.add(rolemodule);
		}
		this.insert(list);
	}
}
