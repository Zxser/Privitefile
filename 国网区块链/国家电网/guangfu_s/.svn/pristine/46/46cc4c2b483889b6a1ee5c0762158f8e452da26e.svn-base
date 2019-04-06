package com.dh.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dh.system.base.BaseController;
import com.dh.system.po.SysUserManage;
import com.dh.system.po.SysUserRole;
import com.dh.system.service.SysModuleService;
import com.dh.system.service.SysUserManageService;
import com.dh.system.service.SysUserRoleService;
import com.dh.utils.CheckCellphone;
import com.dh.utils.Constant;
import com.dh.utils.JwtUtil;
import com.dh.utils.MD5Util;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/manage")
@Api(value = "管理员登陆",description="管理员登陆接口 api", tags = "管理员登陆接口")
public class LoginAdminController extends BaseController {
	@Autowired
	private SysUserManageService userManageService;
	@Autowired
	private JwtUtil jwt;
	
	@Autowired
	private SysModuleService moduleService;

	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录", notes = "用户登录")
	public Map<String, Object> loginCheck(@ApiParam(value = "登录信息", required = true) @RequestBody SysUserManage user) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		if (StringUtils.isEmpty(user.getPassword())||StringUtils.isEmpty(user.getUsername())) {
			map.put("status",1);
			map.put("msg", "用户名和密码不能为空");
		} else {
			SysUserManage valUser = userManageService.getUserByName(user.getUsername());
			if (valUser == null) {
				map.put("status",1);
				map.put("msg", "用户名不存在");
				return map;
			} else {
				if(valUser.getPassword().equalsIgnoreCase(MD5Util.getPassword(user.getPassword()))){
					user=valUser;
					if ("1".equals(user.getStatus())) {
						map.put("status",1);
						map.put("msg", "用户被停用请联系管理员！");
					}else{
						SysUserRole sys_role_module=new SysUserRole();
						sys_role_module.setUserId(user.getId());
						List<SysUserRole> findBySysUserRole = sysUserRoleService.findBySysUserRole(sys_role_module);
						Long[] roleID=new Long[findBySysUserRole.size()];
						int i=0;
						for (SysUserRole sysUserRole : findBySysUserRole) {
							roleID[i]=sysUserRole.getRoleId();i++;
						}
						user.setRoleId(roleID);
						String subject =JwtUtil.generalSubject(valUser);
						String token = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
						String refreshToken = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_REFRESH_TTL);
						JSONObject jo = new JSONObject();
						jo.put("token", token);
						jo.put("status",0);
						jo.put("refreshToken", refreshToken);
						return jo;
					}
				}else{
					map.put("status",1);
					map.put("msg", "密码不正确");
				}
			}
		}
		return map;
	}

	
	@ApiOperation(value="退出系统", notes="请求退出系统登陆")
	@GetMapping("/logout")
	public R logout(){
		session.invalidate();
		return R.ok();
	}
}
