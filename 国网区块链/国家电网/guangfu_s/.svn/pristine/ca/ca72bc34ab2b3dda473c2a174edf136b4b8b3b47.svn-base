package com.dh.system.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.dh.backview.po.SysUser;
import com.dh.backview.service.SysUserService;
import com.dh.system.base.BaseController;
import com.dh.system.po.SysUserManage;
import com.dh.system.po.SysUserRole;
import com.dh.system.service.SysUserManageService;
import com.dh.system.service.SysUserRoleService;
import com.dh.system.vo.SysUserManageQuery;
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
@RequestMapping("/SysUserManage")
@Api(value = "管理员用户管理",description="用户接口 api", tags = "管理员用户接口")
public class SysUserManageController extends BaseController{
	@Autowired
	private SysUserManageService userManageService;
	@Autowired
	private SysUserService userService;
	@Autowired
	private SysUserRoleService SysUserManageRoleService;
	
	@ApiOperation(value="获取管理员列表", notes="管理员用户数据")
	@PostMapping("/getManageList")
	public R getList(@RequestBody SysUserManageQuery SysUserManageQuery){
		PageInfo pageInfo = new PageInfo(SysUserManageQuery.getPageNum(), SysUserManageQuery.getPageSize());
		userManageService.fingAll(pageInfo, SysUserManageQuery);
		return R.ok().put("page", pageInfo);
	}
	
	
	@ApiOperation(value="获取发电户列表")
	@PostMapping("/getUserList")
	public R getList(@RequestBody SysUserQuery sysUserQuery){
		PageInfo pageInfo = new PageInfo(sysUserQuery.getPageNum(), sysUserQuery.getPageSize());
		userService.fingAll(pageInfo, sysUserQuery);
		return R.ok().put("page", pageInfo);
	}
	
	@ApiOperation(value="根据id获取", notes="根据id获取")
	@GetMapping("/getById/{id}")
	public R getById(@PathVariable(name="id") Long id) {
		try {
			SysUserManage user=userManageService.getById(id);
//			SysUserRole sys_role_module=new SysUserRole();
//			sys_role_module.setUserId(id);
//			List<SysUserRole> SysUserManageRole = SysUserManageRoleService.findBySysUserRole(sys_role_module);
//			Long[]  roleIds=new Long[SysUserManageRole.size()];
//			int i=0;
//			for (SysUserRole  sysUserRole: SysUserManageRole) {
//				roleIds[i++]=sysUserRole.getRoleId();
//			}
//			user.setRoleId(roleIds);
			return	R.ok().put("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
	
//	@ApiOperation(value="保存或者更新", notes="")
//	@PostMapping(value="/save")
//	public R save(@RequestBody SysUserManage SysUserManage) {
//		try {
//			if(null!=SysUserManage.getId()&&0!=SysUserManage.getId()){
//					userManageService.update(SysUserManage);
//			}else{
//				SysUserManage.setCreateTime(new Date());
//				SysUserManage.setPassword(MD5Util.getPassword("123456"));
//				userManageService.save(SysUserManage);
//			}
//			return	R.ok();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return	R.error();
//		} 
//	}
	
	@ApiOperation(value="保存管理员或国网用户", notes="type：0 系统  1 ：国网")
	@PostMapping("/saveUser")
	public R saveUser(@RequestBody SysUserManage userManage) throws Exception {
		try {
			if(userManage.getId()==null&&!StringUtils.isEmpty(userManage.getUsername())){
				SysUserManage phone = userManageService.getUserByName(userManage.getUsername());
				if(null!=phone){
					return	R.error(1001,"用户名已存在");
				}
				userManage.setCreateTime(new Date());
				userManage.setPassword(MD5Util.getPassword("123456"));
				userManageService.save(userManage);
			}else{
				userManageService.update(userManage);
			}
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}	 
	}
	
	@ApiOperation(value="删除用户", notes="根据id删除用户信息")
	@DeleteMapping("/delete/{arrayid}")
	public R delete(@PathVariable(name="arrayid") Long arrayid) {
		try {
			userManageService.delete(arrayid);
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
	
	@ApiOperation(value="验证用户名唯一性", notes="验证用户名唯一性")
	@PostMapping("/SysUserManage/checkUserName")//验证用户名唯一
	public R checkUserName(@RequestBody SysUserManage SysUserManage) throws IOException {
		SysUserManage userByName = userManageService.getUserByName(SysUserManage.getUsername());
		if(null!=userByName){
			return	R.ok().put("status", 1).put("msg", "账号已存在");
		}else{
			return	R.ok().put("status", 0).put("msg", "账号不存在");	
		}
	}
	@ApiOperation(value="验证手机号唯一性", notes="验证手机号唯一性")
	@PostMapping("/SysUserManage/checkPhone")
	public R checkPhone(@RequestBody SysUserManage SysUserManage) throws IOException {
		SysUserManage userByName = userManageService.getUserByPhone(SysUserManage.getPhone());
		if(null!=userByName){
			return	R.ok().put("status", 1).put("msg", "手机号已存在");
		}else{
			return	R.ok().put("status", 0).put("msg", "手机号不存在");	
		}
	}
	
	@ApiOperation(value="设置新密码", notes="设置新密码")
	@PostMapping("/saveNewpwd")
	public R saveNewpwd(@RequestBody SysUserManageQuery sysUserManage) throws Exception {
		Long id = getUserManager().getId();
		SysUserManage	sysUser = userManageService.getById(id);
		String oldpassword = MD5Util.getPassword(sysUserManage.getOldpassword());
		if(oldpassword.equals(sysUser.getPassword())){
			sysUser.setPassword(MD5Util.getPassword(sysUserManage.getPassword()));
			userManageService.update(sysUser);
			return	R.ok();
		}else{
			return	R.error("原密码错误");
		}
	}
}
