package org.taru.lanqiao.util;

public class StringUtil {
	public static String valueOf(Object obj) {
		if(obj!=null) {
			return obj.toString();
		}
		return null;
	}
	
	public static Object isnull(Object obj) {
		if(obj!=null) {
			return obj;
		}
		return 0;
	}
}
