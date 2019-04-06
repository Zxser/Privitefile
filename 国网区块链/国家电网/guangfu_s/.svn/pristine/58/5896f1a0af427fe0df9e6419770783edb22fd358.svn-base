package com.dh.taiyi;

import com.alibaba.fastjson.JSONObject;

public class Test {
    final static String gfbTotalAddr = "1JLfNiyBLVHb7sFvbpBVa8ZnD8yJVJSnnR"; //总帐地址 GFB地址
    final static String abcAddrA = "1BMG55YhdSyvjcY9xArsiGXNJSbvqumSoP"; //185手续费地址 ABC地址
    
	public static void main11() {
		System.out.println("test");
		//节点A IP 192.168.1.185
		CoinInterface cfA = new CoinInterface("http://192.168.1.185:55556", "scnode1", "123456");
		//节点B IP 192.168.1.186
	    CoinInterface cfB = new CoinInterface("http://192.168.1.186:55556", "scnode2", "123456");
		//1. 185节点 生成超导网络地址 sc_newaddr
	    //2. 185节点 往地址打币 SendAssettoAddress
	    //3.  185节点 连接 186构成超导通道 sc_connect
	    
	    String str = "";
	    JSONObject jsStr = null;
	    //1. 185节点 生成超导网络地址
//	    String str = cfA.sc_newaddr();
//	    System.out.println(str);
//	    JSONObject jsStr = JSONObject.parseObject(str);
	   // String sc_addr = jsStr.getJSONObject("result").getString("address");
	    //383PJXYRn6QXqT2AVLCgXRcwD938Y189gL
	    String sc_addr = "383PJXYRn6QXqT2AVLCgXRcwD938Y189gL";
	    //System.out.println(sc_addr);
	    
	   
	  //2. 185节点 往地址打币 SendAssettoAddress
//	    str = cfA.SendAssettoAddress(gfbTotalAddr, sc_addr, 5, abcAddrA, abcAddrA, gfbTotalAddr);
//	    jsStr = JSONObject.parseObject(str);
//	    String txId = jsStr.getJSONObject("result").getString("txid");
//	    System.out.println(txId);
	    //8c1fa8327f0b3a6081e1dc49c7f6e3d0dae64822a0912623e00ccad91864adcc
	    String txId = "8c1fa8327f0b3a6081e1dc49c7f6e3d0dae64822a0912623e00ccad91864adcc";
	
	    
	    //3.  185节点 连接 186构成超导通道 sc_connect
//	    str = cfA.sc_connect("192.168.1.186", 9913, txId);
//	    jsStr = JSONObject.parseObject(str);
//	    String id = jsStr.getJSONObject("result").getString("id");
//	    System.out.println(id); //186节点ID
	    String nodeB_id = "032c867992f517bb3e9f83e7fceb128ac43849729464db0ce5d6cbd37d05cd0cd4";
	    
	    //4.186 节点 生成账单  sc_invoice
//	    str = cfB.sc_invoice(100000000, "zhoufd");
//	    jsStr = JSONObject.parseObject(str);
//	    String rhash = jsStr.getJSONObject("result").getString("rhash");
//	    System.out.println(rhash);
	    String rhash = "ed138d29c68fe40f146ee23e065c8941ae35cf69ddc89f927d887a8cce0da43c";
	    
	    //5.185节点 获取支付路径
//	    str = cfA.sc_getroute(nodeB_id, 100000000, 1);
//	    System.out.println(str);
//	    jsStr = JSONObject.parseObject(str);
//	    JSONObject route = jsStr.getJSONObject("result").getJSONArray("route").getJSONObject(0);
//	    nodeB_id = route.getString("id");
//	    String satoshi = route.getString("satoshi");
//	    String delay = route.getString("delay");
//	    System.out.println("nodeB_id:"+nodeB_id);
//	    System.out.println("satoshi:"+satoshi);
//	    System.out.println("delay:"+delay);
	    nodeB_id="032c867992f517bb3e9f83e7fceb128ac43849729464db0ce5d6cbd37d05cd0cd4";
	    int satoshi=100000000;
	    int delay = 36;
	    
	    //6.185节点 给 186 支付
//	    str = cfA.sc_sendpay(nodeB_id, satoshi, delay, rhash, "nodeA pay  to zhoufd: "+satoshi);
//	    jsStr = JSONObject.parseObject(str);
//	    String preimage = jsStr.getJSONObject("result").getString("preimage");
//	    System.out.println("preimage:"+preimage);
	    //e6ae7adc49dfe14b89a861304416b951204656f9d05d7802dde0d7f80448a06e
	    
	    //7.查看通道中两个节点的总帐
//	    str = cfA.sc_getpeers();
//	    System.out.println("str:"+str);
	    
	    //8.查看账单详细信息
//	    str = cfB.sc_listinvoice();
//	    System.out.println("str:"+str);
//	    str = cfB.sc_listinvoice("zhoufd");
//	    System.out.println("str:"+str);
	    
	    //9.关闭超导网络
	    str = cfA.sc_close(nodeB_id);
	    System.out.println("str:"+str);
	    
	}

}
