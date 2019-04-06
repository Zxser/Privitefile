package com.dh.system.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dh.config.ConfigProperties;
import com.dh.system.base.BaseController;
import com.dh.utils.R;
import com.dh.utils.RandomNum;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* 文件上传
 * @author Administrator
 *
 */
@RestController
@RequestMapping
@Api(value = "上传文件信息",description="上传接口 api", tags = "上传文件信息")
public class UploadFileController extends BaseController{
	@Autowired
	private ConfigProperties config;
	
	@ApiOperation(value="上传pid图片", notes="上传pid接口")
	@PostMapping(value="/uploadImage")
	public R uploadImage(@ApiParam(required = true, value = "图片") @RequestParam(value = "image") MultipartFile image) {
		if(image.isEmpty()){
			return R.error();
		}
		 String fileName = image.getOriginalFilename();
		 logger.info("上传的文件名为：" + fileName);
		 String suffixName = fileName.substring(fileName.lastIndexOf("."));
		 logger.info("上传的后缀名为：" + suffixName);
		 logger.info("上传文件地址："+config.getFilePath()+ fileName);
		 
		 SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");
		    String dateformat=df.format(new Date());
		    String dateTimeformat=df1.format(new Date());
		     fileName=dateTimeformat+RandomNum.genRandomNum(2)+suffixName;
		     String pathString =null;
		     if(fileName.equalsIgnoreCase("pdf")){
		    	 pathString="/pdf/"+dateformat+"/"+fileName;
		     }else{
		    	 pathString = "/"+dateformat+"/"+fileName;
		     }
		 
		 File dest = new File(config.getFilePath() + pathString);
		  if (!dest.getParentFile().exists()) {
		         dest.getParentFile().mkdirs();
		  }try {
			  image.transferTo(dest);
		   } catch(IOException e) {
		         e.printStackTrace();
		         return R.error();
		 }
		 return R.ok().put("imagePath", pathString);
	}
	
	
}
