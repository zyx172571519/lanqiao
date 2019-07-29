package org.taru.lanqiao.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

public class YearDao {
	public List selectTop(String year) throws ParseException {
		String sql = "SELECT ORDER_TOTAL_PRICE FROM order_list where ORDER_DATE_TIME >= ? and ORDER_DATE_TIME <= ?";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date d1 = sdf.parse(year + "-01-00");
		Date d2 = sdf.parse(year + "-03-32");
		List<HashMap<String, Object>> list1 = SqlUtil.executeQuery(sql, d1, d2);

		Date d3 = sdf.parse(year + "-04-00");
		Date d4 = sdf.parse(year + "-06-32");
		List<HashMap<String, Object>> list2 = SqlUtil.executeQuery(sql, d3, d4);

		Date d5 = sdf.parse(year + "-07-00");
		Date d6 = sdf.parse(year + "-09-32");
		List<HashMap<String, Object>> list3 = SqlUtil.executeQuery(sql, d5, d6);

		Date d7 = sdf.parse(year + "-10-00");
		Date d8 = sdf.parse(year + "-12-32");
		List<HashMap<String, Object>> list4 = SqlUtil.executeQuery(sql, d7, d8);
		
		HashMap<String, Object> hm1 = new HashMap<String, Object>();
		HashMap<String, Object> hm2 = new HashMap<String, Object>();
		HashMap<String, Object> hm3 = new HashMap<String, Object>();
		HashMap<String, Object> hm4 = new HashMap<String, Object>();
		BigDecimal SUMER1 = new BigDecimal(0);
		BigDecimal SUMER2 = new BigDecimal(0);
		BigDecimal SUMER3 = new BigDecimal(0);
		BigDecimal SUMER4 = new BigDecimal(0);
		
		if(list1.size()>0) {
			for(int i = 0; i<list1.size();i++) {
				BigDecimal j = new BigDecimal(StringUtil.iszore(list1.get(i).get("ORDER_TOTAL_PRICE")).toString()); 
				SUMER1 = SUMER1.add(j);
			}
		}
		if(list2.size()>0) {
			for(int i = 0; i<list2.size();i++) {
				BigDecimal j = new BigDecimal(StringUtil.iszore(list2.get(i).get("ORDER_TOTAL_PRICE")).toString()); 
				SUMER2 = SUMER2.add(j);
			}
		}
		if(list3.size()>0) {
			for(int i = 0; i<list3.size();i++) {
				BigDecimal j = new BigDecimal(StringUtil.iszore(list3.get(i).get("ORDER_TOTAL_PRICE")).toString()); 
				SUMER3 = SUMER3.add(j);
			}
		}
		if(list4.size()>0) {
			for(int i = 0; i<list4.size();i++) {
				BigDecimal j = new BigDecimal(StringUtil.iszore(list4.get(i).get("ORDER_TOTAL_PRICE")).toString()); 
				SUMER4 = SUMER4.add(j);
			}
		}
		hm1.put("MONTHS","第一季度");
		hm1.put("SUMER", SUMER1);
		hm2.put("MONTHS","第二季度");
		hm2.put("SUMER", SUMER2);
		hm3.put("MONTHS","第三季度");
		hm3.put("SUMER", SUMER3);
		hm4.put("MONTHS","第四季度");
		hm4.put("SUMER", SUMER4);
		
		List li = new ArrayList<>();
		li.add(hm1);
		li.add(hm2);
		li.add(hm3);
		li.add(hm4);
		SqlUtil.close();

		return li;
	}
}
