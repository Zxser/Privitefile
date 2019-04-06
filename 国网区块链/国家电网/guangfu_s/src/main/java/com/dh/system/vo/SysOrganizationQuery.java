package com.dh.system.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.dh.system.base.BaseEntity;

/**
 * 系统组织机构
 * 
 * @author liliangliang
 *
 */
public class SysOrganizationQuery  extends  BaseEntity{
	/** 组织机构id */
	private Long id;
	/** 机构名称 */
	private String name;
	
	private String code;//组织代码
	private String abbreviation;//简称
	private Date create_date;//创建日期
	private Date start_date;//开始日期
	private Date end_date;//截止日期
	/** 上级节点 */
	private Long pid;
	/** 上级组织机构对象 */
	private SysOrganizationQuery parent;
	/** 下级组织机构集合 */
	private List<SysOrganizationQuery> children;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public SysOrganizationQuery getParent() {
		return parent;
	}
	public void setParent(SysOrganizationQuery parent) {
		this.parent = parent;
	}
	public List<SysOrganizationQuery> getChildren() {
		return children;
	}
	public void setChildren(List<SysOrganizationQuery> children) {
		this.children = children;
	}
}