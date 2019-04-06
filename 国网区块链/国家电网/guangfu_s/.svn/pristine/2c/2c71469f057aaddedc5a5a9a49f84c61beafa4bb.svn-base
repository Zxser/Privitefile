package com.dh.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
/**
 * @ClassName BusinessProperties
 * @Description 配置文件模型类
 */
@ConfigurationProperties(prefix = "config",locations="classpath:/config.properties")  
public class ConfigProperties {
	private String filePath;
	private String serviceUrl;
	private String username;
	private String password;
	public String symbol;
	public  String gfbTotalAddr ; //总帐地址 GFB地址
	public String cosefee; //找零地址

	public String getCosefee() {
		return cosefee;
	}

	public void setCosefee(String cosefee) {
		this.cosefee = cosefee;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getGfbTotalAddr() {
		return gfbTotalAddr;
	}

	public void setGfbTotalAddr(String gfbTotalAddr) {
		this.gfbTotalAddr = gfbTotalAddr;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	

}
