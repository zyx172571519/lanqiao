package org.taru.lanqiao.util;

public class StringUtil {
	public static Object isnull(Object obj) {
		if(obj != null) {
			return obj;
		}
		return null;
	}
	
	public static Object iszore(Object obj) {
		if(obj != null) {
			return obj;
		}
		return 0;
	}

	
	public static String valueOf(Object obj) {
		if(obj!=null) {
			return obj.toString();
		}
		return null;
	}
}
