package org.taru.lanqiao.util;

public class DoubleTo {
	public static Double value(Object obj) {
		if(obj!=null) {
			return Double.valueOf(StringUtil.valueOf(obj));
		}
		return null;
	}
}
