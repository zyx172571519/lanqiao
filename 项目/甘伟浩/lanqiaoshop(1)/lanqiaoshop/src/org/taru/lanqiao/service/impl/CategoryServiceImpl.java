package org.taru.lanqiao.service.impl;

import java.util.List;

import org.taru.lanqiao.dao.CategoryDao;
import org.taru.lanqiao.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao categoryDao = new CategoryDao();
	
	@Override
	public List categoryFindAll() {
		List list = categoryDao.categoryFindAll();
		return list;
	}

}
