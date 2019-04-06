package com.dh.guangfu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.guangfu.po.CmsType;
import com.dh.guangfu.service.CmsTypeService;
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
@RequestMapping("/CmsType")
@Api(value = "新闻类型管理",description="新闻类型管理", tags = "新闻类型管理")
public class CmsTypeController extends BaseController{
	@Autowired
	private CmsTypeService CmsTypeService;
	
	@ApiOperation(value="获取列表", notes="获取列表")
	@PostMapping(value="/getList")
	public R getList() {
		List<CmsType> list=CmsTypeService.fingAll();
		return R.ok().put("list", list);
	}
	
	@ApiOperation(value="获取单个类型", notes="获取单个类型")
	@GetMapping(value="/getListById/{arrayid}")
	public R getListById(@PathVariable(name="arrayid") Long arrayid) {
		CmsType cmsType=CmsTypeService.fingById(arrayid);
		return R.ok().put("cmsType", cmsType);
	}
	
	
	@ApiOperation(value="保存或者更新", notes="")
	@PostMapping(value="/save")
	public R save(@RequestBody CmsType CmsType) {
		try {
			if(null!=CmsType.getId()&&0!=CmsType.getId()){
					CmsTypeService.update(CmsType);
			}else{
				CmsTypeService.save(CmsType);
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
			CmsTypeService.delete(arrayid);
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
}
