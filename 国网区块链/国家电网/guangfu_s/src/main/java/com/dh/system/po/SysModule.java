package com.dh.system.po;

import java.io.Serializable;
import java.util.List;

/**
 * 系统资源模块
 * 
 * @author liliangliang
 *
 */
public class SysModule implements Serializable {

	private static final long serialVersionUID = 2820710039321811868L;
	/** 主键 */
	private Long id;
	/** 模块名称 */
	private String name;
	/** 优先次序 */
	private Integer sort;
	/** 地址 */
	private String url;
	/** 标识 */
	private String sn;
	/** 标识 */
	private String description;
	/** 上级节点id */
	private Long parentId;
	/** 子节点集合 */
	private List<SysModule> children;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
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
	public List<SysModule> getChildren() {
		return children;
	}
	public void setChildren(List<SysModule> children) {
		this.children = children;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}