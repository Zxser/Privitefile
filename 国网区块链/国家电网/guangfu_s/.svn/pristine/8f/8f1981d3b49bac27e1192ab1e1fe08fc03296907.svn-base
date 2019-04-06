package com.dh.taiyi.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	public static boolean isEmpty(Object obj) {
		return (null == obj || String.valueOf(obj).trim().length() == 0);
	}
	
	public static String firstUpper(String src) {
		if (isEmpty(src)) {
			return src;
		}
		return new String(src.substring(0, 1).toUpperCase() + src.substring(1));
	}
	
	public static String parseNull(String src) {
		return isEmpty(src) ? "" : String.valueOf(src);
	}

	public static boolean isInteger(String src) {
		if (isEmpty(src)) {
			return false;
		}
		Matcher mer = Pattern.compile("^[0-9]+$").matcher(src.trim());  
        return mer.find();
	}
}
