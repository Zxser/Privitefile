package com.dh.guangfu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.guangfu.po.Area;
import com.dh.guangfu.service.AreaService;
import com.dh.system.base.BaseController;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 列表
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/Area")
@Api(value = "区域管理",description="区域管理", tags = "区域管理")
public class AreaController extends BaseController{
	@Autowired
	private AreaService AreaService;
	
	@ApiOperation(value="获取列表", notes="获取列表")
	@GetMapping(value="/getList/{city_id}")
	public R getList(@PathVariable(name="city_id") Integer city_id) {
		List<Area> list=AreaService.fingAllByCityId(city_id);
		return R.ok().put("list", list);
	}
	
	@ApiOperation(value="根据id获取", notes="根据id获取")
	@GetMapping(value="/getListById/{id}")
	public R getListById(@PathVariable(name="id") Long id) {
		Area Area=AreaService.fingById(id);
		return R.ok().put("Area", Area);
	}
}
