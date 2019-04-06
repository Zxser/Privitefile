package com.dh.guangfu.server;

import java.text.SimpleDateFormat;
import java.util.Date;

public class demo {
    public static void main(String[] args) {
    	Date date = new Date("2017/01/01");
    	System.out.println(date);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
    	System.out.println(sdf.format(date));
    	System.out.println(sdf.format(date).toString() instanceof  String);
	}
}
