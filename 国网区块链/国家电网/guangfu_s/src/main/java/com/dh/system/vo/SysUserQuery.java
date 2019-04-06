package com.dh.system.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.dh.system.base.BaseEntity;

/**
 * 系统角色模块
 *
 */
public class SysUserQuery extends  BaseEntity {
	private Long[]  arrayid;
	private Long id;
	/** 用户名 */
	@NotNull(message = "用户名称不能为空") 
	private String username;
	
	private String oldpassword;
	
	private String newpassword;
	private String pay_password;
	
	@NotNull(message = "手机号不能为空") 
	private String phone;
	
	private String sign;//验证码
	/** 头像 */
	private String head;
	private String coin_address;
	/**昵称 */
	private String nickname;
	@JSONField(format="yyyy-MM-dd")
	private Date createTime;
	@NotNull(message = "状态不能为空")
	private String status;
	private String card_id;
	private Integer type;
	private Long area_id;
	private String privatekey;
	
	
	public String getPay_password() {
		return pay_password;
	}
	public void setPay_password(String pay_password) {
		this.pay_password = pay_password;
	}
	public String getPrivatekey() {
		return privatekey;
	}
	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}
	public String getCoin_address() {
		return coin_address;
	}
	public void setCoin_address(String coin_address) {
		this.coin_address = coin_address;
	}
	public Long getArea_id() {
		return area_id;
	}
	public void setArea_id(Long area_id) {
		this.area_id = area_id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long[] getArrayid() {
		return arrayid;
	}
	public void setArrayid(Long[] arrayid) {
		this.arrayid = arrayid;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}