package com.dh.system.po;

import java.io.Serializable;
import java.util.Date;

import com.dh.system.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户公钥  私钥---
 * 
 * @author liliangliang
 *
 */
public class SysUserKey implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	/** 私钥 */
	private String privatekey;
	/** 公钥 */
	private String publickey;
	
	private Long user_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrivatekey() {
		return privatekey;
	}

	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}

	public String getPublickey() {
		return publickey;
	}

	public void setPublickey(String publickey) {
		this.publickey = publickey;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	
}