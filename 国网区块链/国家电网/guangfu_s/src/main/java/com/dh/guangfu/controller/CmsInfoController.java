package com.dh.guangfu.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dh.guangfu.vo.CmsInfoQuery;
import com.dh.system.base.BaseController;
import com.dh.system.base.MongodInfoRepository;
import com.dh.system.base.SpringDataPageable;
import com.dh.system.po.CmsInfoMongo;
import com.dh.utils.PageInfo;
import com.dh.utils.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 新闻内容管理
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/CmsInfo")
@Api(value = "新闻内容管理", description = "新闻内容管理", tags = "新闻内容管理")
public class CmsInfoController extends BaseController {
	// @Autowired
	// private CmsInfoService cmsInfoService;
	@Autowired
	private MongodInfoRepository mongodInfoRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	@ApiOperation(value = "获取列表", notes = "获取列表")
	@PostMapping(value = "/getList")
	public R getList(@RequestBody CmsInfoQuery cmsInfoQuery) {
		pageInfo = new PageInfo(cmsInfoQuery.getPageNum(), cmsInfoQuery.getPageSize());
		Sort sort = new Sort(Direction.ASC, "createdate");
		SpringDataPageable pageable = new SpringDataPageable();
		pageable.setPagenumber(cmsInfoQuery.getPageNum());// 开始页
		pageable.setPagesize(cmsInfoQuery.getPageSize()); // 每页条数
		pageable.setSort(sort);

		Query query = new Query();
		if (!StringUtils.isEmpty(cmsInfoQuery.getTitle())) {
			query.addCriteria(Criteria.where("title").regex(cmsInfoQuery.getTitle() + ".*"));
		}
		if (!StringUtils.isEmpty(cmsInfoQuery.getTypeName())) {
			Criteria criteria = Criteria.where("typeName").is(cmsInfoQuery.getTypeName());
			query.addCriteria(criteria);
		}
		Long count = mongoTemplate.count(query, CmsInfoMongo.class);
		List<CmsInfoMongo> find = mongoTemplate.find(query.with(pageable), CmsInfoMongo.class);
		pageInfo.setList(find);
		pageInfo.setPage(Integer.parseInt(count + ""), cmsInfoQuery.getPageSize());
		return R.ok().put("pageInfo", pageInfo);
	}

	@ApiOperation(value = "获取单个类型", notes = "获取单个类型")
	@GetMapping(value = "/getListById/{arrayid}")
	public R getListById(@PathVariable(name = "arrayid") String arrayid) {
		CmsInfoMongo cmsInfo = mongodInfoRepository.findById(arrayid);
		return R.ok().put("cmsInfo", cmsInfo);
	}

	@ApiOperation(value = "保存或者更新", notes = "")
	@PostMapping(value = "/save")
	public R save(@RequestBody CmsInfoMongo cmsInfo) {
		try {
			if (null != cmsInfo.getId()) {
				if ("".equals(cmsInfo.getId())) {
					cmsInfo.setId(null);
				}
				cmsInfo.setCreatedate(new Date());
			}
			mongoTemplate.save(cmsInfo);
			return R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
	}

	@ApiOperation(value = "删除id", notes = "根据id删除")
	@PostMapping("/delete")
	public R delete(@RequestBody CmsInfoQuery cmsInfoQuery) {
		try {
			String[] arrayId = cmsInfoQuery.getArrayId();
			for (String str : arrayId) {
				mongodInfoRepository.deleteById(str);
			}
			return R.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
	}
}
