package com.dh.guangfu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.guangfu.po.PriceType;
import com.dh.guangfu.service.PriceTypeService;
import com.dh.guangfu.vo.PriceTypeQuery;
import com.dh.system.base.BaseController;
import com.dh.utils.PageInfo;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 价格类型管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/priceType")
@Api(value = "后台价格类型管理",description="后台价格类型管理", tags = "后台价格类型管理")
public class PriceTypeController extends BaseController{
	@Autowired
	private PriceTypeService PriceTypeService;
	
	@ApiOperation(value="获取全部类型", notes="获取全部类型")
	@GetMapping(value="/getAll")
	public R getAll() {
		List<PriceType> list=PriceTypeService.fingAll();
		return R.ok().put("list", list);
	}
	@ApiOperation(value="获取列表", notes="获取列表")
	@PostMapping(value="/getList")
	public R getList(@RequestBody PriceTypeQuery PriceType) {
		PageInfo  pageInfo=new PageInfo(PriceType.getPageNum(),PriceType.getPageSize());
		PriceTypeService.findPage(pageInfo,PriceType);
		return R.ok().put("page", pageInfo);
	}
	
	@ApiOperation(value="获取单个类型", notes="获取单个类型")
	@GetMapping(value="/getById/{id}")
	public R getListById(@PathVariable(name="id") Long id) {
		PriceType PriceType=PriceTypeService.fingById(id);
		return R.ok().put("priceType", PriceType);
	}
	
	
	@ApiOperation(value="保存或者更新", notes="")
	@PostMapping(value="/save")
	public R save(@RequestBody PriceType PriceType) {
		try {
			if(null!=PriceType.getId()&&0!=PriceType.getId()){
					PriceTypeService.update(PriceType);
			}else{
				PriceTypeService.save(PriceType);
			}
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		} 
	}
	
	@ApiOperation(value="删除id", notes="根据id删除")
	@DeleteMapping("/delete/{arrayid}")
	public R delete(@PathVariable(name="arrayid") Long arrayid) {
		try {
			PriceTypeService.delete(arrayid);
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
}
