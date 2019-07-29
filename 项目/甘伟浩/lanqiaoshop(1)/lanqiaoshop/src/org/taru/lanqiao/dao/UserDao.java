package org.taru.lanqiao.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.taru.lanqiao.model.User;
import org.taru.lanqiao.util.PageHelper;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

/**
 * 用户DAO层
 * 
 * @author CoCo
 *
 */
public class UserDao {

	// 查询用户
	public PageHelper userSelectAll(int pageNum, int pageSize, String telphone, String shopName) {
		List list = new ArrayList();
		PageHelper pageHelper = new PageHelper();
		int total = 0;
		int pages = 0;
		String sql1;
		String sql2;
		if (telphone == null && shopName == null) {
			sql1 = "select * from user limit ?,?";
			sql2 = "select count(*) as row from user";
			List<HashMap<String, Object>> list2 = SqlUtil.executeQuery(sql2);
			if (list2.size() > 0) {
				total = Integer.valueOf(StringUtil.isnull(list2.get(0).get("row")).toString());
				pages = (total % pageSize == 0 ? total / pageSize : total / pageSize + 1);
			}

			List<HashMap<String, Object>> list1 = SqlUtil.executeQuery(sql1, (pageNum - 1) * pageSize, pageSize);
			for (int i = 0; i < list1.size(); i++) {
				User user = new User();
				user.setUserId(StringUtil.isnull(list1.get(i).get("USER_ID")).toString());
				user.setUserUserName(StringUtil.isnull(list1.get(i).get("USER_USER_NAME")).toString());
				user.setUserPassword(StringUtil.isnull(list1.get(i).get("USER_PASSWORD")).toString());
				user.setUserTelphone(StringUtil.isnull(list1.get(i).get("USER_TELPHONE")).toString());
				user.setUserAddress(StringUtil.isnull(list1.get(i).get("USER_ADDRESS")).toString());
				user.setUserShopName(StringUtil.isnull(list1.get(i).get("USER_SHOP_NAME")).toString());
				user.setUserComment(StringUtil.isnull(list1.get(i).get("USER_COMMENT")).toString());
				user.setUserStatus(Byte.valueOf(StringUtil.isnull(list1.get(i).get("USER_STATUS")).toString()));
				list.add(user);
			}
			pageHelper.setList(list);
			pageHelper.setPageNum(pageNum);
			pageHelper.setPageSize(pageSize);
			pageHelper.setTotal(total);
			pageHelper.setPages(pages);
			SqlUtil.close();
			return pageHelper;
		} else {
			sql1 = "select * from user where USER_TELPHONE=? or USER_SHOP_NAME=? limit ?,?";
			sql2 = "select count(*) as row from user where USER_TELPHONE=? or USER_SHOP_NAME=?";

			List<HashMap<String, Object>> list2 = SqlUtil.executeQuery(sql2, telphone, shopName);
			if (list2.size() > 0) {
				total = Integer.valueOf(StringUtil.isnull(list2.get(0).get("row")).toString());
				pages = (total % pageSize == 0 ? total / pageSize : (total / pageSize) + 1);
			}

			List<HashMap<String, Object>> list1 = SqlUtil.executeQuery(sql1, telphone, shopName,
					(pageNum - 1) * pageSize, pageSize);
			for (int i = 0; i < list1.size(); i++) {
				User user = new User();
				user.setUserId(StringUtil.isnull(list1.get(i).get("USER_ID")).toString());
				user.setUserUserName(StringUtil.isnull(list1.get(i).get("USER_USER_NAME")).toString());
				user.setUserPassword(StringUtil.isnull(list1.get(i).get("USER_PASSWORD")).toString());
				user.setUserTelphone(StringUtil.isnull(list1.get(i).get("USER_TELPHONE")).toString());
				user.setUserAddress(StringUtil.isnull(list1.get(i).get("USER_ADDRESS")).toString());
				user.setUserShopName(StringUtil.isnull(list1.get(i).get("USER_SHOP_NAME")).toString());
				user.setUserComment(StringUtil.isnull(list1.get(i).get("USER_COMMENT")).toString());
				user.setUserStatus(Byte.valueOf(StringUtil.isnull(list1.get(i).get("USER_STATUS")).toString()));
				list.add(user);
			}
			pageHelper.setList(list);
			pageHelper.setPageNum(pageNum);
			pageHelper.setPageSize(pageSize);
			pageHelper.setTotal(total);
			pageHelper.setPages(pages);
			SqlUtil.close();
			return pageHelper;
		}
	}

	// 根据ID查询用户
	public User userFindById(String id) {
		String sql = "select * from user where USER_ID=?";
		List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, id);
		User user;
		if (list.size() > 0) {
			user = new User();
			user.setUserId(StringUtil.isnull(list.get(0).get("USER_ID")).toString());
			user.setUserUserName(StringUtil.isnull(list.get(0).get("USER_USER_NAME")).toString());
			user.setUserPassword(StringUtil.isnull(list.get(0).get("USER_PASSWORD")).toString());
			user.setUserTelphone(StringUtil.isnull(list.get(0).get("USER_TELPHONE")).toString());
			user.setUserAddress(StringUtil.isnull(list.get(0).get("USER_ADDRESS")).toString());
			user.setUserShopName(StringUtil.isnull(list.get(0).get("USER_SHOP_NAME")).toString());
			user.setUserComment(StringUtil.isnull(list.get(0).get("USER_COMMENT")).toString());
			user.setUserStatus(Byte.valueOf(StringUtil.isnull(list.get(0).get("USER_STATUS")).toString()));
			SqlUtil.close();
			return user;
		}
		SqlUtil.close();
		return null;
	}

	// 添加用户
	public int userAdd(User user) {
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		int i = SqlUtil.executeUpdate(sql, user.getUserId(), user.getUserUserName(), user.getUserPassword(),
				user.getUserTelphone(), user.getUserAddress(), user.getUserShopName(), user.getUserComment(),
				user.getUserStatus());
		SqlUtil.close();
		return i;
	}
	
	//删除用户
	public int userDelete(String id, int status) {
		String sql = "update user set USER_STATUS=? where USER_ID=?";
		int i = SqlUtil.executeUpdate(sql, status, id);
		SqlUtil.close();
		return i;
	}
	
	//商城用户修改
	public int userUpdate(User user) {
		int i = 0;
		if(user.getUserUserName()!=null) {
			String sql = "update user set USER_USER_NAME=? where USER_ID=?";
			i = SqlUtil.executeUpdate(sql, user.getUserUserName(), user.getUserId());
		}
		if(user.getUserPassword()!=null) {
			String sql = "update user set USER_PASSWORD=? where USER_ID=?";
			i = SqlUtil.executeUpdate(sql, user.getUserPassword(), user.getUserId());
		}
		if(user.getUserTelphone()!=null) {
			String sql = "update user set USER_TELPHONE=? where USER_ID=?";
			i = SqlUtil.executeUpdate(sql, user.getUserTelphone(), user.getUserId());
		}
		if(user.getUserShopName()!=null) {
			String sql = "update user set USER_SHOP_NAME=? where USER_ID=?";
			i = SqlUtil.executeUpdate(sql, user.getUserShopName(), user.getUserId());
		}
		if(user.getUserAddress()!=null) {
			String sql = "update user set USER_ADDRESS=? where USER_ID=?";
			i = SqlUtil.executeUpdate(sql, user.getUserAddress(), user.getUserId());
		}
		if(user.getUserComment()!=null) {
			String sql = "update user set USER_COMMENT=? where USER_ID=?";
			i = SqlUtil.executeUpdate(sql, user.getUserComment(), user.getUserId());
		}
		SqlUtil.close();
		return i;
	}

}
