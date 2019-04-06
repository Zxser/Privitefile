package com.dh.guangfu.po;

import java.io.Serializable;
/**
 * 个人电表绑定
 * @author liliangliang
 *
 */
public class UserMeter implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String meter_ID; //电表id
	private String name; //用户名
	private String card_id; //身份证号
	private String phone; //手机号
	private String remark; //备注
	private Long   user_id; //用户id
	private Integer status; //状态  0 待审核  1 已审核   2 已拒绝
	private String address; //地址
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMeter_ID() {
		return meter_ID;
	}
	public void setMeter_ID(String meter_ID) {
		this.meter_ID = meter_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
