package com.dh.guangfu.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
/**
 * 每日上网量
 * @author liliangliang
 *
 */
public class TrafficElectricity implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Long user_id ;//用户id

    private Long num;//上网量
    private Date create_date; // 上网日期

    private int year;
    private int month;
    private int day;
    
    
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public TrafficElectricity() {}
	
	public TrafficElectricity(Long user_id, Long num) {
		this.user_id = user_id;
		this.num = num;
		Calendar calendar=Calendar.getInstance();
		this.create_date = calendar.getTime();
		this.year=calendar.get(Calendar.YEAR);  
		this.month=calendar.get(Calendar.MONTH);  
		this.day=calendar.get(Calendar.DAY_OF_MONTH);  
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

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
}