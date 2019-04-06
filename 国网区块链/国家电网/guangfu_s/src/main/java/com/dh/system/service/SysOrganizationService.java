package com.dh.system.service;

import java.util.List;

import com.dh.system.po.SysOrganization;
import com.dh.system.vo.SysOrganizationQuery;
import com.dh.utils.PageInfo;

public interface SysOrganizationService {
	SysOrganization getSysModuleById(Long id);
	/**
	 * 根据角色id查询权限模块
	 * @param roleId
	 * @return
	 */
	SysOrganization getSysOrganizationById(Long organizationId);
	void update(SysOrganization sysOrganization);
	void delete(Long arrayid);
	void save(SysOrganization sysOrganization);
	List<SysOrganization> fingAll(SysOrganization sysOrganization);
	List<SysOrganization> fingAllTop();
	List<SysOrganization> fingAllchildren(Long parentId);
	List<SysOrganization> fingAllByTree();
	void fingAll(PageInfo pageInfo, SysOrganizationQuery sysOrganization);
}
