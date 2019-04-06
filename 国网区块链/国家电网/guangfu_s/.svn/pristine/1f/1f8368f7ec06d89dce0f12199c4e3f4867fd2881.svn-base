package com.dh.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dh.system.base.BaseDaoImpl;
import com.dh.system.po.SysOrganization;
import com.dh.system.service.SysOrganizationService;
import com.dh.system.vo.SysOrganizationQuery;
import com.dh.utils.PageInfo;
import com.github.pagehelper.PageHelper;
@Service
public class SysOrganizationServiceImpl extends BaseDaoImpl<SysOrganization> implements SysOrganizationService{

	@Override
	public SysOrganization getSysModuleById(Long id) {
		return this.findOne("findById", id, SysOrganization.class);
	}

	@Override
	public void fingAll(PageInfo pageInfo, SysOrganizationQuery sysOrganization) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize()).setOrderBy("id desc");
		List<SysOrganization> findList = this.findList("findPage", sysOrganization,SysOrganization.class);
		Integer i =this.findOne("count", sysOrganization,Integer.class);
		pageInfo.setList(findList);
		pageInfo.setPage(i, pageInfo.getPageSize());
		
	}
	
	@Override
	public SysOrganization getSysOrganizationById(Long organizationId) {
		SysOrganization selectByPrimaryKey = this.findOne("findById", organizationId, SysOrganization.class);
		Long pid = selectByPrimaryKey.getPid();
		if(null!=pid){
			selectByPrimaryKey.setParent(this.findOne("findById", pid, SysOrganization.class));
		}
		return selectByPrimaryKey;
	}
	@Transactional
	public void update(SysOrganization sysOrganization) {
		this.update("update", sysOrganization);
	}
	@Transactional
	public void delete(Long arrayid) {
		this.delete("deleteById", arrayid);
	}
	@Transactional
	public void save(SysOrganization sysOrganization) {
		sysOrganization.setCreate_date(new Date());
		this.save("insert", sysOrganization);
	}

	@Override
	public List<SysOrganization> fingAllByTree() {
		List<SysOrganization> top = this.fingAllTop();
		List<SysOrganization> fingAllTree = fingAllTree(top);
		return fingAllTree;
	}
	@Override
	public List<SysOrganization> fingAll(SysOrganization sysOrganization) {
		List<SysOrganization> list;
		if(null!=sysOrganization.getId()){
			list=this.fingAllchildren(sysOrganization.getId());
		}else{
			 list=this.fingAllTop();
		}
		if(null!=list&&list.size()>0){
			for (SysOrganization sysOrganization2 : list) {
				if(null!=sysOrganization2.getPid()){
					SysOrganization parent = this.findOne("findById", sysOrganization2.getPid(), SysOrganization.class);
					sysOrganization2.setParent(parent);
				}
			}
		}
		return list;
	}
	/**
	 * 递归查询树结构
	 * @param top 
	 * @return
	 */
	public List<SysOrganization> fingAllTree(List<SysOrganization> top) {
		for (SysOrganization next : top) {
			List<SysOrganization> fingAllchildren = this.fingAllchildren(next.getId());
			if(null!=fingAllchildren&&fingAllchildren.size()>0){
				next.setChildren(fingAllchildren);
				this.fingAllTree(fingAllchildren);
			}
		}
		return top;
	}
	/**
	 * 查询顶级
	 */
	@Override
	public List<SysOrganization> fingAllTop() {
		return this.findList("top", null, SysOrganization.class);
	}
	/**
	 * 查询孩子节点
	 */
	@Override
	public List<SysOrganization> fingAllchildren(Long parentId) {
		if(parentId!=null){
			return this.findList("children", parentId, SysOrganization.class);
		}
		return null;
	}
}
