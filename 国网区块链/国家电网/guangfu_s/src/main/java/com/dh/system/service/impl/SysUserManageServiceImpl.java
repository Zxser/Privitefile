package com.dh.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.dh.system.base.BaseDaoImpl;
import com.dh.system.po.SysUserManage;
import com.dh.system.po.SysUserRole;
import com.dh.system.service.SysUserManageService;
import com.dh.system.service.SysUserRoleService;
import com.dh.system.vo.SysUserManageQuery;
import com.dh.utils.PageInfo;
import com.github.pagehelper.PageHelper;

@Service
public class SysUserManageServiceImpl extends BaseDaoImpl<SysUserManage>  implements SysUserManageService{
	@Autowired
	private SysUserRoleService SysUserManageRoleService;
	
	
	@Override
	public SysUserManage getSysUserManageById(Long id) {
		SysUserManage selectByPrimaryKey =this.findOne("findById", id, SysUserManage.class);
		return selectByPrimaryKey;
	}

	@Override
	public SysUserManage getUserByName(String username) {
		SysUserManage  user=this.findOne("findUserByName", username, SysUserManage.class);
		return user;
	}
	
	@Transactional
	public void save(SysUserManage SysUserManage) {
		super.save("insert",SysUserManage);
//		Long[] roleId = SysUserManage.getRoleId();
//		if(null!=roleId&&roleId.length>0){
//			List<SysUserRole> list=new ArrayList<SysUserRole>();
//			for (Long id : roleId) {
//				SysUserRole SysUserManageRole=new SysUserRole();
//				SysUserManageRole.setRoleId(id);
//				SysUserManageRole.setUserId(SysUserManage.getId());
//				list.add(SysUserManageRole);
//			}
//			SysUserManageRoleService.save(list);
//		}
		
	}
	@Transactional
	public void update(SysUserManage SysUserManage) throws Exception {
		if(StringUtils.isEmpty(SysUserManage.getPassword())){
			SysUserManage findOne = super.findOne("findById", SysUserManage, SysUserManage.class);
			SysUserManage.setPassword(findOne.getPassword());
		}
		super.update("update", SysUserManage);
		Long[] roleId = SysUserManage.getRoleId();
		if(roleId!=null){
			SysUserManageRoleService.deleteByUserId(SysUserManage.getId());//删除
		}
		
		if(null!=roleId&&roleId.length>0){
			List<SysUserRole> list=new ArrayList<SysUserRole>();
			for (Long id : roleId) {
				SysUserRole SysUserManageRole=new SysUserRole();
				SysUserManageRole.setRoleId(id);
				SysUserManageRole.setUserId(SysUserManage.getId());
				list.add(SysUserManageRole);
			}
			SysUserManageRoleService.save(list);
		}
	}

	@Override
	public void fingAll(PageInfo pageInfo,SysUserManageQuery SysUserManage) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize()).setOrderBy("id desc");
		List<SysUserManage> findList = this.findList("selectAll", SysUserManage,SysUserManage.class);
		Integer i =this.findOne("count", SysUserManage,Integer.class);
		pageInfo.setList(findList);
		pageInfo.setPage(i, pageInfo.getPageSize());
	}
	
	@Transactional
	public void delete(Long arrayid) {
//			SysUserManage SysUserManage = this.findOne("findById",arrayid, SysUserManage.class);
//			SysUserManageRoleService.deleteByUserId(SysUserManage.getId());//中间表删除
		 super.delete("deleteById",arrayid);
	}

	@Override
	public SysUserManage getById(Long id) {
		SysUserManage SysUserManage = this.findOne("findById",id, SysUserManage.class);
		
		return SysUserManage;
	}

	@Override
	public SysUserManage getUserByPhone(String phone) {
		SysUserManage  user=this.findOne("getUserByPhone", phone, SysUserManage.class);
		return user;
	}
}
