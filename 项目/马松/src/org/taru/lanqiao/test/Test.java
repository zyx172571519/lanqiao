package org.taru.lanqiao.test;

import org.taru.lanqiao.util.DbUtil;

public class Test {

	public static void main(String[] args) {
		DbUtil.query("select * from  product");
	}
}
