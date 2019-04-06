package com.dh.guangfu.po;

import java.io.Serializable;
/**
 * 个人银行列表
 * @author liliangliang
 *
 */
public class UserBank implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String true_name; //真是姓名
	private String bank_num; //银行卡号
	private String address; //开户地址
	private String card_id; //身份证号
	private Long user_id; //用户id
	private String phone; //手机号  临时
	private String sign; //验证码     临时
	
	
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
	public String getTrue_name() {
		return true_name;
	}
	public void setTrue_name(String true_name) {
		this.true_name = true_name;
	}
	public String getBank_num() {
		return bank_num;
	}
	public void setBank_num(String bank_num) {
		this.bank_num = bank_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
}
