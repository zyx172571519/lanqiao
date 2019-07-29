package org.taru.lanqiao.service;

import org.taru.lanqiao.dao.AddDao;

import com.sun.org.apache.regexp.internal.recompile;

public class LeibieService {
	
	public int addleibie(int categoryId,String categoryName,int categoryStatus) {
		 AddDao hh =new AddDao();
		 int s= hh.AddCategory(categoryId, categoryName, categoryStatus);
		 return s;
		 
	}
}
