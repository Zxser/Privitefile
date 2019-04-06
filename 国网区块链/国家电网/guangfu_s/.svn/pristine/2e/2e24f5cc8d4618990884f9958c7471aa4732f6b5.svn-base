package com.dh.system.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alibaba.fastjson.JSONObject;
import com.dh.backview.po.SysUser;
import com.dh.system.po.SysUserManage;
import com.dh.utils.PageInfo;
import com.dh.utils.StringEscapeEditor;

import io.jsonwebtoken.Claims;


public abstract class BaseController {
	public PageInfo pageInfo;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected Map<String,Object> result;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	public SysUser getLoginUser() {
		if(null!=request.getAttribute("claims")){
			Claims claims = (Claims) request.getAttribute("claims");
			String json = claims.getSubject();
			SysUser user = JSONObject.parseObject(json, SysUser.class);
			return user;
		}
		return null;
	}
	public SysUserManage getUserManager() {
		if(null!=request.getAttribute("claims")){
			Claims claims = (Claims) request.getAttribute("claims");
			String json = claims.getSubject();
			SysUserManage user = JSONObject.parseObject(json, SysUserManage.class);
			return user;
		}
		return null;
	}
	public JSONObject getJSONObject(String result) {
		if(null!=result){
			JSONObject jsStr = JSONObject.parseObject(result);
			if(StringUtils.isEmpty(jsStr.getString("error"))){
				return jsStr;
			}
		}
		return null;
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm"), true));
		 /**
         * 防止XSS攻击
         */
        binder.registerCustomEditor(String.class, new StringEscapeEditor());
	}
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	/** 
	 * @Description: 返回html数据
	 * @throws IOException 
	 * @return HttpServletResponse 
	 */
	protected HttpServletResponse gethtmlRes() throws IOException {
		response.setContentType("textml;charset=utf-8");
		return response;
	}

	/** 
	 * @Description: 返回json数据
	 * @throws IOException 
	 * @return PrintWriter 
	 */
	protected PrintWriter getJsonWriter() throws IOException {
		response.setContentType("text/json;charset=utf-8");
		return response.getWriter();
	}

	/** 
	 * @Description: 返回html数据
	 * @return
	 * @throws IOException 
	 * @return PrintWriter 
	 */
	protected PrintWriter getXmlWriter() throws IOException {
		response.setContentType("text/xml;charset=utf-8");
		return response.getWriter();
	}
	
	@ModelAttribute
	protected void initAttribute(HttpServletRequest request, HttpServletResponse response){
		this.request=request;
		this.response=response;
		this.session=request.getSession();
		this.result=new HashMap<String,Object>();
	}
}
