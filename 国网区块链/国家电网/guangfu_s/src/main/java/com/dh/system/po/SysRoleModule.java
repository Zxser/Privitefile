package com.dh.system.po;

import java.io.Serializable;

import com.dh.system.vo.JSONModule;

/**
 * 角色-->模块中间表（角色与模块多对多关系）
 * 
 * @author liliangliang
 *
 */
public class SysRoleModule implements Serializable {

	private static final long serialVersionUID = 3739242356194151119L;
	/** 角色id */
	private Long roleId;
	/** 资源id */
	private Long moduleId;

	private Long pid;
	
	private Integer sort;
	
	private JSONModule[] JSONModule;
	
	private SysModule[] sysModule;
	
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public SysModule[] getSysModule() {
		return sysModule;
	}

	public void setSysModule(SysModule[] sysModule) {
		this.sysModule = sysModule;
	}

	

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	
	
	public JSONModule[] getJSONModule() {
		return JSONModule;
	}

	public void setJSONModule(JSONModule[] jSONModule) {
		JSONModule = jSONModule;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
}