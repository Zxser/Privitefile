package com.dh.backview.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.backview.po.SysUser;
import com.dh.backview.service.SysUserService;
import com.dh.system.base.BaseController;
import com.dh.system.vo.SysUserQuery;
import com.dh.utils.MD5Util;
import com.dh.utils.PageInfo;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 用户控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping
@Api(value = "发电用户管理",description="发电用户接口 api", tags = "发电用户接口")
public class SysUserController extends BaseController{
	@Autowired
	private SysUserService userService;
	
	@ApiOperation(value="获取用户列表", notes="分页用户数据")
	@PostMapping("/sysuser/getList")
	public R getList(@RequestBody SysUserQuery sysUserQuery){
		PageInfo pageInfo = new PageInfo(sysUserQuery.getPageNum(), sysUserQuery.getPageSize());
		userService.fingAll(pageInfo, sysUserQuery);
		return R.ok().put("page", pageInfo);
	}
	
	@ApiOperation(value="保存或者更新", notes="")
	@PostMapping(value="/sysuser/save")
	public R save(@RequestBody SysUser sysUser) {
		try {
			if(null!=sysUser.getId()&&0!=sysUser.getId()){
					userService.update(sysUser);
			}else{
				sysUser.setCreateTime(new Date());
				sysUser.setPassword(MD5Util.getPassword("123456"));
				userService.save(sysUser);
			}
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		} 
	}
	
	@ApiOperation(value="删除用户", notes="根据id删除用户信息")
	@PostMapping("/sysuser/delete")
	public R delete(@RequestBody SysUserQuery sysUser) {
		try {
			userService.delete(sysUser.getArrayid());
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
	
	@ApiOperation(value="验证用户名唯一性", notes="验证用户名唯一性")
	@PostMapping("/sysUser/checkUserName")//验证用户名唯一
	public R checkUserName(@RequestBody SysUser sysUser) throws IOException {
		SysUser userByName = userService.getUserByName(sysUser.getUsername());
		if(null!=userByName){
			return	R.ok().put("status", 1).put("msg", "账号已存在");
		}else{
			return	R.ok().put("status", 0).put("msg", "账号不存在");	
		}
	}
	@ApiOperation(value="验证手机号唯一性", notes="验证手机号唯一性")
	@PostMapping("/sysUser/checkPhone")
	public R checkPhone(@RequestBody SysUser sysUser) throws IOException {
		SysUser userByName = userService.getUserByPhone(sysUser.getPhone());
		if(null!=userByName){
			return	R.ok().put("status", 1).put("msg", "手机号已存在");
		}else{
			return	R.ok().put("status", 0).put("msg", "手机号不存在");	
		}
	}
	
	@ApiOperation(value="设置新密码", notes="设置新密码")
	@PostMapping("/sysUser/saveNewpwd")
	public R saveNewpwd(@RequestBody SysUserQuery sysUserQuery) {
		try {
			SysUser	sysUser = userService.getUserByPhone(sysUserQuery.getPhone());
			String oldpassword = MD5Util.getPassword(sysUserQuery.getOldpassword());
			if(oldpassword.equalsIgnoreCase(sysUser.getPassword())){
				sysUser.setPassword(sysUserQuery.getNewpassword());
				userService.update(sysUser);
				return	R.ok();
			}else{
				return	R.error("原密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
}
