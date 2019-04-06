package com.dh.guangfu.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.util.StringUtils;
import com.dh.backview.po.SysUser;
import com.dh.backview.service.SysUserService;
import com.dh.config.ConfigProperties;
import com.dh.guangfu.po.UserMeter;
import com.dh.guangfu.service.UserMeterService;
import com.dh.system.base.BaseController;
import com.dh.system.po.SysUserManage;
import com.dh.system.service.SysUserManageService;
import com.dh.system.vo.SysUserQuery;
import com.dh.utils.MD5Util;
import com.dh.utils.R;
import com.dh.utils.RandomNum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 用户控制器
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/userCenter")
@Api(value = "发电户主页中心",description="发电户主页中心 api", tags = "发电户主页中心接口")
public class SysUserInfoController extends BaseController{
	@Autowired
	private SysUserService userService;
	@Autowired
	private UserMeterService userMeterService;
	@Autowired
	private ConfigProperties config;
	@Autowired
	private SysUserManageService userManageService;
	
	
	@ApiOperation(value="获取用户基础信息", notes="获取用户基础信息")
	@GetMapping("/getUserInfo")
	public R getUserInfo() throws Exception {
		try {
			SysUserQuery user=userService.getSysUserById(getLoginUser().getId());
			List<UserMeter> userMeter=userMeterService.fingByUserId(getLoginUser().getId());
			return	R.ok().put("user", user).put("userMeterList", userMeter);
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}	
	}
	
	@ApiOperation(value="首页总数", notes="首页总数")
	@GetMapping("/indexTotal")
	public R indexTotal() {
		Map<String,Object> map=new HashMap<>();
		map.put("userTotal", 111);
		map.put("integralToal", 23432);
		map.put("electricityToal", 321312);
		return	R.ok().put("total", map);	
	}
	
	@ApiOperation(value="设置数字证书密码", notes="设置数字证书新密码 {pay_password:提现密码,oldpassword:老密码}")
	@PostMapping("/saveNewPayPwd")
	public R saveNewPayPwd(@RequestBody SysUserQuery sysUserInfo) throws Exception {
		SysUser sysUserOld = userService.getById(getLoginUser().getId());
		if(org.apache.commons.lang3.StringUtils.isBlank(sysUserOld.getPay_password())){
			if(sysUserOld.getPassword().equals(MD5Util.getPassword(sysUserInfo.getOldpassword()))){
				return	R.error("原密码错误");	
			}
		}
		sysUserOld.setPay_password(MD5Util.getPassword(sysUserInfo.getPay_password()));
		userService.update(sysUserOld);
		return	R.ok();	
	}
	
	@ApiOperation(value="设置登陆密码", notes="设置登陆密码 {newpassword:提现密码,oldpassword:老密码}")
	@PostMapping("/savePwd")
	public R savePwd(@RequestBody SysUserQuery sysUserInfo) throws Exception {
		SysUser sysUserOld = userService.getById(getLoginUser().getId());
		if(sysUserOld.getPassword().equals(MD5Util.getPassword(sysUserInfo.getOldpassword()))){
			return	R.error("原密码错误");	
		}
		sysUserOld.setPassword(MD5Util.getPassword(sysUserInfo.getNewpassword()));
		userService.update(sysUserOld);
		return	R.ok();	
	}
	
	@ApiOperation(value="设置用户基础信息", notes="设置用户基础信息")
	@PostMapping("/saveUserInfo")
	public R saveUserInfo(@RequestBody SysUser sysUserInfo) {
		SysUser	oldsysUserInfo=userService.getById(getLoginUser().getId());
		try {
			sysUserInfo.setId(oldsysUserInfo.getId());
			userService.update(sysUserInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
		return	R.ok();
	}
	
	@ApiOperation(value="上传pid图片", notes="上传pid接口")
	@PostMapping(value="/uploadImage")
	public R uploadImage(@ApiParam(required = true, value = "图片") @RequestParam(value = "image") MultipartFile image) {
		if(image.isEmpty()){
			return R.error();
		}
		 String fileName = image.getOriginalFilename();
		 logger.info("上传的文件名为：" + fileName);
		 String suffixName = fileName.substring(fileName.lastIndexOf("."));
		 logger.info("上传的后缀名为：" + suffixName);
		 logger.info("上传文件地址："+config.getFilePath()+ fileName);
		 
		 SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");
		    String dateformat=df.format(new Date());
		    String dateTimeformat=df1.format(new Date());
		     fileName=dateTimeformat+RandomNum.genRandomNum(2)+suffixName;
		     String pathString =null;
		     pathString = "/"+dateformat+"/"+fileName;
		 File dest = new File(config.getFilePath() + pathString);
		  if (!dest.getParentFile().exists()) {
		         dest.getParentFile().mkdirs();
		  }try {
			  image.transferTo(dest);
			  SysUser userInfo = userService.getById(getLoginUser().getId());
			  userInfo.setHead(pathString);
			  userService.update(userInfo);
			  return R.ok().put("imagePath", pathString);
		   } catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
	}
	
}
