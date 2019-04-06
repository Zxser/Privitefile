package com.dh.guangfu.po;

import java.io.Serializable;
import java.util.Map;
/**
 * 用户总数据量
 * @author liliangliang
 *
 */
public class ServerData implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String value;
	private String address;
	private String hash;
	public ServerData() {  
        
    }
	public ServerData(Map<String,Object> s) {  
        this.value = (String) s.get("value");
        this.address = (String) s.get("address");
        this.hash = (String) s.get("hash");
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
}