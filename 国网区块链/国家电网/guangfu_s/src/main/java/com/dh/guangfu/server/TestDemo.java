package com.dh.guangfu.server;

import org.junit.Test;

import com.dh.utils.HttpRequest;

public class TestDemo {
	/**
	 * 购买电测试类
	 */
	@Test
	public void testBuyInsuance(){
		HttpRequest h = new HttpRequest();
//		h.sendPost("http://127.0.0.1/electricity/save","{\"buyAddress\":\"ddress 001\",\"sellAddress\":\"aaaaaaa\",\"buyTime\":\"2017-01-01\",\"state\":\"1\",\"electricity\":\"10\"}");
		h.sendGet("http://127.0.0.1/createCaoDaoLink", "");
		
	}
}
