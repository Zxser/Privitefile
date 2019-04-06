package com.dh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfig extends WebMvcConfigurerAdapter {
	 @Override
	  public void addInterceptors(InterceptorRegistry registry) { 
	    // 多个拦截器组成一个拦截器链 
	    // addPathPatterns 用于添加拦截规则 
	    // excludePathPatterns 用户排除拦截 
	    registry.addInterceptor(new WebFilter()).addPathPatterns("/**")
	    .excludePathPatterns("/home/login")
	    .excludePathPatterns("/map/getInfo/**")
	    .excludePathPatterns("/swagger-resources/**")
	    .excludePathPatterns("/v2/**")
	    .excludePathPatterns("/sysUser/checkPhone")
	    .excludePathPatterns("/sysUser/checkUserName") 
	    .excludePathPatterns("/userCenter/indexTotal")
	    .excludePathPatterns("/manage/login")
	    .excludePathPatterns("/createCaoDaoLink")
	    .excludePathPatterns("/druid/**")
	    .excludePathPatterns("/home/register")
	    .excludePathPatterns("/ServerData/**")
	    .excludePathPatterns("/electricity/**");
	    super.addInterceptors(registry); 
	  } 
    }