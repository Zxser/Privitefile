package com.dh.backview.po;

import java.io.Serializable;
import java.util.Date;

import com.dh.system.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 系统用户
 * 
 * @author liliangliang
 *
 */
public class SysUser implements Serializable {

	private static final long serialVersionUID = -3588375571928978178L;
	/** 用户id */
	private Long id;
	/** 用户名 */
	private String username;
	/** 密码 */
	private String password;
	/** 手机号 */
	private String phone;
	/** 用户状态：0启动 1禁用 */
	private String status;
	private String card_id;//身份证号
	
	private String coin_address;//用户地址
	private String meter_address;//电表地址
	private String head;//头像
	private String nickname;//昵称
	/** 私钥 */
	private String privatekey;
	
	private String sign;//临时变量  短信验证码
	private String 	pay_password;
	private Integer type;//  1 个人   2 企业
	
	public String getMeter_address() {
		return meter_address;
	}
	public void setMeter_address(String meter_address) {
		this.meter_address = meter_address;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getPrivatekey() {
		return privatekey;
	}
	public void setPrivatekey(String privatekey) {
		this.privatekey = privatekey;
	}

	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getPay_password() {
		return pay_password;
	}
	public void setPay_password(String pay_password) {
		this.pay_password = pay_password;
	}
	public String getCoin_address() {
		return coin_address;
	}
	public void setCoin_address(String coin_address) {
		this.coin_address = coin_address;
	}
	/** 创建日期 */	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createTime;
	
	
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
}