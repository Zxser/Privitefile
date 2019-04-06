package com.dh.guangfu.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dh.guangfu.po.ProductionElectricity;
import com.dh.guangfu.po.TrafficElectricity;
import com.dh.guangfu.service.ProductionElectricityService;
import com.dh.guangfu.vo.TrafficElectricityQuery;
import com.dh.system.base.BaseController;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 发电量管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/productionElectricity")
@Api(value = "发电户发电量",description="发电户发电量管理", tags = "发电户发电量管理")
public class ProductionElectricityController extends BaseController{
	@Autowired
	private ProductionElectricityService ProductionElectricityService;
		
	
	@ApiOperation(value="获取个人本月上网量列表", notes="根据当前登陆的用户获得")
	@PostMapping(value="/getByMonth")
	public R getTrafficElectricity(@RequestBody TrafficElectricityQuery trafficElectricityQuery) {
		trafficElectricityQuery.setUser_id(getLoginUser().getId());
		
		List<ProductionElectricity> productionElectricityList=null;
		
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat simp=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(!StringUtils.isEmpty(trafficElectricityQuery.getStartDate())){
			calendar.setTime(trafficElectricityQuery.getStartDate());
			
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 30);
			trafficElectricityQuery.setEndDate(calendar.getTime());
		}
		if(!StringUtils.isEmpty(trafficElectricityQuery.getEndDate())){
			calendar.setTime(trafficElectricityQuery.getEndDate());
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 30);
			trafficElectricityQuery.setStartDate(calendar.getTime());
		}
		if(StringUtils.isEmpty(trafficElectricityQuery.getStartDate())&&StringUtils.isEmpty(trafficElectricityQuery.getEndDate())){
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 30);
			trafficElectricityQuery.setStartDate(calendar.getTime());
			trafficElectricityQuery.setEndDate(new Date());
		}
		
		System.out.println("开始"+simp.format(trafficElectricityQuery.getStartDate()));
		System.out.println("截止"+simp.format(trafficElectricityQuery.getEndDate()));
		
		productionElectricityList=ProductionElectricityService.fingByUserReport(trafficElectricityQuery);
		
		StringBuilder num=new StringBuilder();
		StringBuilder month=new StringBuilder();
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		for (ProductionElectricity trafficElectricity2 : productionElectricityList) {
			num.append(trafficElectricity2.getNum()+",");
			month.append(date.format(trafficElectricity2.getCreate_date())+",");
		}
	
		if(productionElectricityList.size()>0){
			num.deleteCharAt(num.length()-1);
			month.deleteCharAt(month.length()-1);
		}
		return R.ok().put("num", num).put("month", month);
	}
	
	@ApiOperation(value="查询个人按年月", notes="根据当前登陆的用户获得")
	@PostMapping(value="/getDate")
	public R getDate(@RequestBody TrafficElectricityQuery trafficElectricityQuery) {
		trafficElectricityQuery.setUser_id(getLoginUser().getId());
		List<ProductionElectricity> productionElectricity=null;
		
		if(!StringUtils.isEmpty(trafficElectricityQuery.getEndDate())){
			trafficElectricityQuery.setEndDate(trafficElectricityQuery.getEndDate());
		}
		if(!StringUtils.isEmpty(trafficElectricityQuery.getStartDate())&&StringUtils.isEmpty(trafficElectricityQuery.getYear())){
			productionElectricity=ProductionElectricityService.fingByProductionElectricityQuery(trafficElectricityQuery);
		}
		if(!StringUtils.isEmpty(trafficElectricityQuery.getYear())){
			productionElectricity=ProductionElectricityService.fingByProductionElectricityQuery(trafficElectricityQuery);
		}
		return R.ok().put("bean", productionElectricity);
	}
	
	@ApiOperation(value="保存或者更新", notes="")
	@PostMapping(value="/save")
	public R save(@RequestBody ProductionElectricity trafficElectricity) {
		try {
			trafficElectricity.setUser_id(getLoginUser().getId());
			for (int i = 0; i <1065; i++) {
				Calendar calendar=Calendar.getInstance();
				calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - i);
				trafficElectricity.setCreate_date(calendar.getTime());
				trafficElectricity.setYear(calendar.get(Calendar.YEAR));
				trafficElectricity.setMonth(calendar.get(Calendar.MONTH)+1);
				trafficElectricity.setDay(calendar.get(Calendar.DAY_OF_MONTH));
				trafficElectricity.setNum(new Random().nextInt(10)*2L);
				ProductionElectricityService.save(trafficElectricity);
			}
//			ProductionElectricityService.save(trafficElectricity);
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
			ProductionElectricityService.delete(arrayid);
			return	R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return	R.error();
		}
	}
}
