package com.dh.guangfu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.guangfu.po.UserMeter;
import com.dh.guangfu.service.UserMeterService;
import com.dh.guangfu.vo.UserMeterQuery;
import com.dh.system.base.BaseController;
import com.dh.utils.PageInfo;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**电表管理页
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/userMeter")
@Api(value = "发电户电表",description="发电户电表", tags = "发电户电表管理")
public class UserMeterController extends BaseController{
	@Autowired
	private UserMeterService UserMeterService;
		
	@ApiOperation(value="获取发电户电表类型", notes="获取发电户电表类型")
	@GetMapping(value="/getUserMeter")
	public R getUserMeter() {
		List<UserMeter> userMeter=UserMeterService.fingByUserId(getLoginUser().getId());
		return R.ok().put("userMeter", userMeter);
	}
	
	@ApiOperation(value="管理员审批列表", notes="status; //状态  0 待审核  1 已审核   2 已拒绝     为空全部")
	@PostMapping(value="/getAllPage")
	public R getAllPage(@RequestBody UserMeterQuery userMeterQuery) {
		PageInfo  pageInfo=new PageInfo(userMeterQuery.getPageNum(),userMeterQuery.getPageSize());
		UserMeterService.fingByPage(pageInfo,userMeterQuery);
		return R.ok().put("page", pageInfo);
	}
	
	
	@ApiOperation(value="保存或者更新", notes="")
	@PostMapping(value="/save")
	public R save(@RequestBody UserMeter UserMeter) {
		try {
			UserMeter.setUser_id(getLoginUser().getId());
			if(null!=UserMeter.getId()&&0!=UserMeter.getId()){
				UserMeterService.update(UserMeter);
			}else{
				UserMeterService.save(UserMeter);
			}
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		} 
	}
	
	@ApiOperation(value="删除id", notes="根据id删除")
	@PostMapping("/delete/{id}")
	public R delete(@PathVariable(name="id") Long arrayid) {
		try {
			UserMeterService.delete(arrayid);
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
	
	@ApiOperation(value="审核id同意", notes="status; // 1 已审核   2 已拒绝 ")
	@PostMapping("/agree")
	public R agree(@RequestBody UserMeterQuery userMeterQuery) {
		try {
			UserMeterService.updateAgree(userMeterQuery);
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
	
	@ApiOperation(value="根据id获取信息", notes="根据id获取信息")
	@PostMapping("/getByid/{id}")
	public R getByid(@PathVariable(name="id") Long id) {
		try {
			UserMeter userMeter=UserMeterService.getById(id);
			return	R.ok().put("userMeter", userMeter);
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
}
