package org.taru.lanqiao.dao;

import java.util.List;

import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.util.SqlUtil;

/**
 * 类别DAO层
 * @author CoCo
 *
 */
public class CategoryDao {
	
	//查询类别列表
	public List categoryFindAll() {
		String sql = "select * from category order by CATEGORY_ORDER asc";
		List list = SqlUtil.executeQuery(sql);
		SqlUtil.close();
		return list;
	}
}
