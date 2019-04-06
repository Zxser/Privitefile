package com.dh.frontview.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dh.backview.po.SysUser;
import com.dh.backview.service.SysUserService;
import com.dh.guangfu.service.NodeAddressService;
import com.dh.guangfu.service.TaiyiService;
import com.dh.system.base.BaseController;
import com.dh.taiyi.CoinInterface;
import com.dh.utils.CheckCellphone;
import com.dh.utils.Constant;
import com.dh.utils.JwtUtil;
import com.dh.utils.MD5Util;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/home")
@Api(value = "发电户登陆",description="发电户登陆接口 api", tags = "发电户登陆接口")
public class LoginController extends BaseController {
	@Autowired
	private SysUserService userService;
	@Autowired
	private NodeAddressService nodeAddressService;
	@Autowired
	private TaiyiService taiyiService;
	
	@Autowired
	private JwtUtil jwt;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录", notes = "用户登录", position = 1, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "登录成功")})
	public Map<String, Object> loginCheck(@ApiParam(value = "登录信息", required = true) @RequestBody SysUser user) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		if (StringUtils.isEmpty(user.getPassword())||(StringUtils.isEmpty(user.getPhone())&&StringUtils.isEmpty(user.getUsername()))) {
			map.put("status",1);
			map.put("msg", "手机号或用户名和密码不能为空");
		} else {
			SysUser valUser=null; 
			if((!StringUtils.isEmpty(user.getUsername())&&CheckCellphone.isChinaPhoneLegal(user.getUsername()))){
				valUser = userService.getUserByPhone(user.getUsername());
			 }else{
				 valUser = userService.getUserByName(user.getUsername());
			 }
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
						JSONObject jo1 = new JSONObject();
						jo1.put("id", user.getId());
//						jo.put("type", user.getType());
//						String subject = JwtUtil.generalSubject(user);
						String subject=jo1.toJSONString();
						String token = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
						String refreshToken = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_REFRESH_TTL);
						
						JSONObject jo = new JSONObject();
						jo.put("token", token);
						jo.put("status",0);
						jo.put("refreshToken", refreshToken);
						jo.put("nickname", user.getUsername());
//						jo.put("type", user.getType());
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
	
	@ApiOperation(value="注册发电户用户", notes="注册发电户用户")
	@PostMapping("/register")
	public R register(@RequestBody SysUser user) throws Exception{
		if(StringUtils.isEmpty(user.getPhone())||StringUtils.isEmpty(user.getUsername())||StringUtils.isEmpty(user.getPassword())){
			return R.error().put("msg", "参数不合法");
		}
		CoinInterface coinInterface = taiyiService.getCoinInterface();
		String getNewAddress = taiyiService.GetNewAddress("");
		JSONObject jsStr =getJSONObject(getNewAddress);
		if(null!=jsStr){
			String sc_addr = jsStr.getString("result");
			user.setCoin_address(sc_addr);
			String privatekey = coinInterface.getPrivatekey(sc_addr);
			user.setPrivatekey(privatekey);
		}
		userService.saveRegister(user);
		
		JSONObject jo1 = new JSONObject();
		jo1.put("id", user.getId());
		String subject=jo1.toJSONString();
		String token = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
		String refreshToken = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_REFRESH_TTL);
		
		JSONObject jo = new JSONObject();
		jo.put("token", token);
		jo.put("status",0);
		jo.put("refreshToken", refreshToken);
		jo.put("nickname", user.getUsername());
//		jo.put("type", user.getType());
		return R.ok().put("token", token).put("status", 0).put("nickname", user.getUsername());
	}
	
	@ApiOperation(value="退出系统", notes="请求退出系统登陆")
	@GetMapping("/logout")
	public R logout(){
		session.invalidate();
		return R.ok();
	}
}
