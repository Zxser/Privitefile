package com.dh.system.po;

import java.io.Serializable;
import java.util.Date;

import com.dh.system.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 系统用户
 * 
 * @author liliangliang
 *
 */
public class SysUserManage implements Serializable {

	private static final long serialVersionUID = -3588375571928978178L;
	/** 用户id */
	private Long id;
	/** 用户名 */
	private String username;
	/** 密码 */
	private String password;
	/** 手机号 */
	private String phone;
	/** 用户状态：0启动 1禁用 */
	private String status;
	/** 角色id */
	private Long[] roleId;
	/** 创建日期 */	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createTime;
	
	private Integer type; //0 个人     1 国网
	private Integer area_id;//区域
	private String areaName;//临时字段
	
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long[] getRoleId() {
		return roleId;
	}
	public void setRoleId(Long[] roleId) {
		this.roleId = roleId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	} 
	
	
}