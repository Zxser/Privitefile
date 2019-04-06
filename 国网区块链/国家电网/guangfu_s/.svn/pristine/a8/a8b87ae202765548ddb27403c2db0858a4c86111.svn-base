package com.dh.guangfu.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.backview.service.SysUserService;
import com.dh.guangfu.po.UserBank;
import com.dh.guangfu.po.UserTotal;
import com.dh.guangfu.service.UserBankService;
import com.dh.guangfu.service.UserTotalService;
import com.dh.guangfu.vo.UserTotalQuery;
import com.dh.system.base.BaseController;
import com.dh.system.vo.SysUserQuery;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 银行卡管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/userBank")
@Api(value = "发电户银行列表",description="发电户银行列表管理", tags = "发电户银行列表管理")
public class UserBankController extends BaseController{
	@Autowired
	private UserBankService userBankService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private UserTotalService userTotalService;
		
	@ApiOperation(value="获取发电户银行卡列表", notes="获取单个类型")
	@GetMapping(value="/getUserBankList")
	public R getUserBankList() {
		Long id = getLoginUser().getId();
		List<UserBank> list=userBankService.fingByUserId(id);
		return R.ok().put("list", list);
	}
	
	
	@ApiOperation(value="保存或者更新", notes="")
	@PostMapping(value="/save")
	public R save(@RequestBody UserBank userBank) {
		try {
			SysUserQuery user=sysUserService.getSysUserById(getLoginUser().getId());
			
			if(user.getPhone().equals(userBank.getPhone())){
				userBank.setUser_id(getLoginUser().getId());
				if(null!=userBank.getId()&&0!=userBank.getId()){
					userBankService.update(userBank);
				}else{
					userBankService.save(userBank);
				}
				return	R.ok();
			}else{
				return	R.error("手机号和注册手机号不一致");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		} 
	}
	
	@ApiOperation(value="获取总积分---可兑换积分---不可兑换积分", notes="获取总积分---可兑换积分---不可兑换积分")
	@GetMapping("/getIntegral")
	public R getIntegral() {
		try {
			UserTotal userTotal=userTotalService.fingByUserId(getLoginUser().getId());	
			return	R.ok().put("total", userTotal);
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
	
	@ApiOperation(value="提现", notes="")
	@PostMapping("/withdrawals")
	public R withdrawals(@RequestBody UserTotalQuery userTotalQuery) {
		try {
			SysUserQuery user=sysUserService.getSysUserById(getLoginUser().getId());
			if(!user.getPhone().equals(userTotalQuery.getPhone())){
				return	R.error("注册手机号不一致！");
			}
			UserTotal userTotal=userTotalService.fingByUserId(getLoginUser().getId());	
			if(userTotal.getAllow_integral().compareTo(new BigDecimal(userTotalQuery.getIntegral()))!= -1){
				userTotal.setAllow_integral(userTotal.getAllow_integral().subtract(new BigDecimal(userTotalQuery.getIntegral())));
				userTotalService.update(userTotal);
				return	R.ok().put("total", userTotal);
			}
			return	R.error("可兑换积分不足！");
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
	
	
	@ApiOperation(value="删除id", notes="根据id删除")
	@GetMapping("/delete/{id}")
	public R delete(@PathVariable(name="id") Long id) {
		try {
			userBankService.delete(id);
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
}
