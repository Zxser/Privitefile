package com.dh.config;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dh.utils.JwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
@Controller
public class WebFilter  implements HandlerInterceptor {
   
	@Autowired
	private JwtUtil jwt;
	
	 @Override
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
        String token = request.getHeader("Authorization");
        if(StringUtils.isBlank(token)){
        	token = request.getHeader("header");
        }
        System.out.println("header="+token);
        
        String url = request.getRequestURL().toString();
        System.out.println(url);
        Claims claims;
		try {
//			token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3RfdG9rZW4iLCJpYXQiOjE0OTUwODg4ODUsInN1YiI6IntcImlkXCI6MjR9IiwiZXhwIjoxNDk1MzA0ODg1fQ.0Wxs4D2vOoeXk7YDe3oTrHl85Tr9axZKD5ijHo60ids";
			 BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()); 
			 jwt = (JwtUtil) factory.getBean("jwtUtil");
			claims = jwt.parseJWT(token);
			request.setAttribute("claims", claims);
	 		return true;
		} catch (ExpiredJwtException e) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		} catch(IllegalArgumentException e){
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}
    }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}