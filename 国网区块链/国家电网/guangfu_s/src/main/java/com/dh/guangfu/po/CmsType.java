package com.dh.guangfu.po;

import java.io.Serializable;

public class CmsType implements Serializable{
	private Long id;
	private String name; //类别名称
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
	
}
