package com.dh.guangfu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.utils.HttpRequest;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/map")
@Api(value = "地图",description="地图理", tags = "地图")
public class MapInterController {

	@ApiOperation(value="获取地图信息", notes="获取地图信息")
	@GetMapping(value="/getInfo/{name}")
	public String getMap(@PathVariable(name="name") String name) {
		String str=HttpRequest.sendGet("http://echarts.baidu.com/gallery/vendors/echarts/map/json/province/"+name+".json", null);
		return str;
	}

}
