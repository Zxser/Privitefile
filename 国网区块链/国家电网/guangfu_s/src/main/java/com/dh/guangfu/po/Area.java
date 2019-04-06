package com.dh.guangfu.po;

import java.io.Serializable;
import java.util.Date;
/**
 * 区域表
 * @author liliangliang
 *
 */
public class Area implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name; //名称
	private Integer city_id;//城市id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCity_id() {
		return city_id;
	}
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}
	
}
