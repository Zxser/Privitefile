package com.dh.guangfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.backview.po.SysUser;
import com.dh.backview.service.SysUserService;
import com.dh.system.base.BaseController;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/phone")
@Api(value = "手机号验证", description = "手机号验证", tags = "手机号验证")
public class PhongSendController extends BaseController {

	@Autowired
	private SysUserService userService;
	
	@ApiOperation(value = "根据手机号获取验证码", notes = "根据手机号获取验证码")
	@GetMapping(value = "/getCode/{phone}")
	public R getCode(@PathVariable(name="phone") String phone) {
		SysUser user = userService.getById(getLoginUser().getId());
		if(!StringUtils.isEmpty(phone)){
			if(phone.equals(user.getPhone())){
				return R.ok().put("code", "8942");
			}else{
				return R.error(1003,"手机号和注册用户手机号不一致");
			}
		}
		return R.error();
	}

}
