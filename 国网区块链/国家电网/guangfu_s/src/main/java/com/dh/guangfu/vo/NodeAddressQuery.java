package com.dh.guangfu.vo;

import com.dh.system.base.BaseEntity;

public class NodeAddressQuery extends BaseEntity{
	private Long id;
	private String area_id; //区域id
	private String super_address; //区域超导地址
	private String transaction_url; //交易节点地址
	private String rpc_name; //节点账号
	private String rpc_password; //交易节点密码
	private String txid; //交易Id
	private Integer note_port; //超导服务端口
	private Integer super_port; //建立超导链接端口
	
	private String area_address; //区域的打币地址  出账（提币），进账 （一天发电量的币）地址

	private Integer manage;//1 主节点 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}

	public String getSuper_address() {
		return super_address;
	}

	public void setSuper_address(String super_address) {
		this.super_address = super_address;
	}

	public String getTransaction_url() {
		return transaction_url;
	}

	public void setTransaction_url(String transaction_url) {
		this.transaction_url = transaction_url;
	}

	public String getRpc_name() {
		return rpc_name;
	}

	public void setRpc_name(String rpc_name) {
		this.rpc_name = rpc_name;
	}

	public String getRpc_password() {
		return rpc_password;
	}

	public void setRpc_password(String rpc_password) {
		this.rpc_password = rpc_password;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public Integer getNote_port() {
		return note_port;
	}

	public void setNote_port(Integer note_port) {
		this.note_port = note_port;
	}

	public Integer getSuper_port() {
		return super_port;
	}

	public void setSuper_port(Integer super_port) {
		this.super_port = super_port;
	}

	public String getArea_address() {
		return area_address;
	}

	public void setArea_address(String area_address) {
		this.area_address = area_address;
	}

	public Integer getManage() {
		return manage;
	}

	public void setManage(Integer manage) {
		this.manage = manage;
	}
	
	
}
