package com.dh.guangfu.po;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
/**
 * 价格表
 * @author liliangliang
 *
 */
public class Electricity implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String buyUserId;//地址，后续更改为userId
	private String sellUserId;//卖电地址
	private double electricity;//电量
	private Date buyTime;//购买时间
	private Long state;//状态：1未结算。2买电已结算。3卖电已结算；
	
	private String address;//中间过度
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Electricity() {  
      
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBuyUserId() {
		return buyUserId;
	}
	public void setBuyUserId(String buyUserId) {
		this.buyUserId = buyUserId;
	}
	public String getSellUserId() {
		return sellUserId;
	}
	public void setSellUserId(String sellUserId) {
		this.sellUserId = sellUserId;
	}
	public double getElectricity() {
		return electricity;
	}
	public void setElectricity(double electricity) {
		this.electricity = electricity;
	}
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	
	
}
