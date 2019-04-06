package com.dh.guangfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.guangfu.po.UserTotal;
import com.dh.guangfu.service.UserTotalService;
import com.dh.system.base.BaseController;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 新闻类型管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/UserTotal")
@Api(value = "发电户总计",description="发电户总计管理", tags = "发电户总计管理")
public class UserTotalController extends BaseController{
	@Autowired
	private UserTotalService UserTotalService;
		
	@ApiOperation(value="获取总积分-总用户量-总发电量", notes="获取单个类型")
	@GetMapping(value="/getUserTotal")
	public R getUserTotal() {
		UserTotal UserTotal=UserTotalService.fingByUserId(getLoginUser().getId());
		return R.ok().put("userTotal", UserTotal);
	}
	
	
	@ApiOperation(value="保存或者更新", notes="")
	@PostMapping(value="/save")
	public R save(@RequestBody UserTotal userTotal) {
		try {
			userTotal.setUser_id(getLoginUser().getId());
			if(null!=userTotal.getId()&&0!=userTotal.getId()){
				UserTotalService.update(userTotal);
			}else{
				UserTotalService.save(userTotal);
			}
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		} 
	}
	
	@ApiOperation(value="删除id", notes="根据id删除")
	@PostMapping("/delete/{arrayid}")
	public R delete(@PathVariable(name="arrayid") Long arrayid) {
		try {
			UserTotalService.delete(arrayid);
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
}
