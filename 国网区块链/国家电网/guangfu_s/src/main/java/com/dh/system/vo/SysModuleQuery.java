package com.dh.system.vo;

import java.util.List;

import com.dh.system.base.BaseEntity;
import com.dh.system.po.SysModule;

public class SysModuleQuery extends BaseEntity{/** 主键 */
	
	private Long[] arrayId;
	
	private String parentName;
	
	private Long id;
	/** 模块名称 */
	private String name;
	/** 优先次序 */
	private Integer sort;
	/** 地址 */
	private String url;
	/** 上级节点id */
	private Long parentId;
	/** 判断等级 */
	private String parents;
	/** 标识 */
	private String sn;
	/** 描述 */
	private String description;
	/** 子节点集合 */
	private List<SysModule> children;
	
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
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
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getParents() {
		return parents;
	}
	public void setParents(String parents) {
		this.parents = parents;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<SysModule> getChildren() {
		return children;
	}
	public void setChildren(List<SysModule> children) {
		this.children = children;
	}
	public Long[] getArrayId() {
		return arrayId;
	}
	public void setArrayId(Long[] arrayId) {
		this.arrayId = arrayId;
	}
	
	
	}