package com.dh.guangfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.guangfu.po.ServerData;
import com.dh.guangfu.service.ServerDataService;
import com.dh.system.base.BaseController;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**电表管理页
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/ServerData")
@Api(value = "发电户电表",description="发电户电表", tags = "发电户电表管理")
public class ServerDataController extends BaseController{
	@Autowired
	private ServerDataService serverDataService;
		
	
	
	
	@ApiOperation(value="保存或者更新", notes="")
	@PostMapping(value="/save")
	public R save(@RequestBody ServerData ServerData) {
		try {
				serverDataService.save(ServerData);
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		} 
	}
	
}
