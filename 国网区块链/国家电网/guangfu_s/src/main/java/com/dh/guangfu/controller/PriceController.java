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

import com.dh.guangfu.po.Price;
import com.dh.guangfu.service.PriceService;
import com.dh.guangfu.vo.PriceQuery;
import com.dh.guangfu.vo.PriceTypeQuery;
import com.dh.system.base.BaseController;
import com.dh.utils.PageInfo;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 价格管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/Price")
@Api(value = "后台价格管理",description="后台价格管理", tags = "后台价格管理")
public class PriceController extends BaseController{
	@Autowired
	private PriceService PriceService;
	
	
	@ApiOperation(value="获取列表", notes="获取列表")
	@PostMapping(value="/getList")
	public R getList(@RequestBody PriceQuery price) {
		PageInfo  pageInfo=new PageInfo(price.getPageNum(),price.getPageSize());
		PriceService.findPage(pageInfo,price);
		return R.ok().put("page", pageInfo);
	}
	
	@ApiOperation(value="根据id获取", notes="根据id获取")
	@GetMapping(value="/getListById/{id}")
	public R getListById(@PathVariable(name="id") Long id) {
		Price Price=PriceService.fingById(id);
		return R.ok().put("Price", Price);
	}
	
	
	@ApiOperation(value="保存或者更新", notes="")
	@PostMapping(value="/save")
	public R save(@RequestBody Price Price) {
		try {
			if(null!=Price.getId()&&0!=Price.getId()){
					PriceService.update(Price);
			}else{
				PriceService.save(Price);
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
			PriceService.delete(arrayid);
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
}
