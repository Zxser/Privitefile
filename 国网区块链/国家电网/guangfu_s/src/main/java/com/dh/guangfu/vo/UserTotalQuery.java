package com.dh.guangfu.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dh.system.base.BaseEntity;
/**
 * 用户总数据量
 * @author liliangliang
 *
 */
public class UserTotalQuery extends BaseEntity {

	private Long id;

    private Long user_id ;//用户id

    private BigDecimal total_integral;//总积分

    private BigDecimal total_electricity; //总发电量

    private BigDecimal total_traffic;// 总上网量

    private BigDecimal allow_integral;//可兑换积分
    
    private BigDecimal ban_integral;//不可兑换积分
    
    private Double integral;//兑换积分数
    
    private String phone;//手机号
    
    private String sign;//验证码
    
    
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Double getIntegral() {
		return integral;
	}

	public void setIntegral(Double integral) {
		this.integral = integral;
	}

	public BigDecimal getAllow_integral() {
		return allow_integral;
	}

	public void setAllow_integral(BigDecimal allow_integral) {
		this.allow_integral = allow_integral;
	}

	public BigDecimal getBan_integral() {
		return ban_integral;
	}

	public void setBan_integral(BigDecimal ban_integral) {
		this.ban_integral = ban_integral;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public BigDecimal getTotal_integral() {
		return total_integral;
	}

	public void setTotal_integral(BigDecimal total_integral) {
		this.total_integral = total_integral;
	}

	public BigDecimal getTotal_electricity() {
		return total_electricity;
	}

	public void setTotal_electricity(BigDecimal total_electricity) {
		this.total_electricity = total_electricity;
	}

	public BigDecimal getTotal_traffic() {
		return total_traffic;
	}

	public void setTotal_traffic(BigDecimal total_traffic) {
		this.total_traffic = total_traffic;
	}
}