package org.taru.lanqiao.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.taru.lanqiao.model.Category;
import org.taru.lanqiao.model.Detail;
import org.taru.lanqiao.model.PageResult;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.IdUtil;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

public class productDaoImpl {
	/**
	 * ������ƷID������
	 */ 
	public Product queryId(String id) {
		String sql="select * from product where PRODUCT_ID=?";
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql,id);
		Product product=null;
		if(list.size()>0) {
			product=new Product();
			product.setProductId(StringUtil.valueOf(list.get(0).get("PRODUCT_ID")));//�ж��Ƿ��п�
			product.setProductName(StringUtil.valueOf(list.get(0).get("PRODUCT_NAME")));
			product.setProductPhoto(StringUtil.valueOf(list.get(0).get("PRODUCT_PHOTO")));
		}
		return product;
	}
	
	/**
	 * ��ѯ��Ʒ����ҳ
	 */
	public PageResult queryListByPage(int pageNum,int pageSize) {
		String sql="select * from product limit ?,?"; //���ݿ�ķ�ҳ�������ҳ�������ݿ��о��Ѿ���ҳ���ˣ�limit��mysq�ķ�ҳ
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql, (pageNum-1)*pageSize,pageSize);
		List<Product> list2=new ArrayList<Product>();
		
		for(int i=0;i<list.size();i++) {
			Product product =new Product();
			product.setProductId(StringUtil.valueOf(list.get(i).get("PRODUCT_ID")));
			product.setProductName(StringUtil.valueOf(list.get(i).get("PRODUCT_NAME")));
			product.setProductPhoto(StringUtil.valueOf(list.get(i).get("PRODUCT_PHOTO")));
			product.setProductSmallPrice(BigDecimal.valueOf(Integer.parseInt(StringUtil.valueOf(list.get(i).get("PRODUCT_SMALL_PRICE")))));
			product.setProductSmallUnit(StringUtil.valueOf(list.get(i).get("PRODUCT_SMALL_UNIT")));
			
			
			list2.add(product);
		}
		PageResult pageResult=new PageResult();
		pageResult.setList(list2);
		pageResult.setPageNum(pageNum);
		pageResult.setPageSize(pageSize);
		
		String sql2="select count(*) as row from product ";
		List<HashMap<String, Object>> countList=SqlUtil.executeQuery(sql2);
		String count =String.valueOf(countList.get(0).get("row"));
		int size =Integer.parseInt(count);
		pageResult.setTotal(size);
		pageResult.setPages(size%pageSize==0?size/pageSize:size/pageSize+1);
		return pageResult;
		
			}
	/**
	 * ��ѯ���еĲ�Ʒ���
	 */
	public List queryCategoryId() {
		String sql="select * from Category ";
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql);
		Category category=null;
		List<Category> list2=new ArrayList<Category>();
		for(int i=0;i<list.size();i++) {
			category=new Category();
			category.setCategoryId(StringUtil.valueOf(list.get(i).get("CATEGORY_ID")));//�ж��Ƿ��п�
			category.setCategoryName(StringUtil.valueOf(list.get(i).get("CATEGORY_NAME")));
			category.setCategoryOrder(Integer.parseInt(StringUtil.valueOf(list.get(i).get("CATEGORY_ORDER"))));
			category.setCategoryStatus(Byte.parseByte((StringUtil.valueOf(list.get(i).get("CATEGORY_STATUS")))));
			list2.add(category);
		}
		return list2;
	}
	
	/**
	 * �û�ɾ��
	 */
	public int deleteById(String id) {
		String sql="update user set user_status=0 where user_id=?";
		int i=SqlUtil.executeUpdate(sql, id);
		return i;
	}
	
	/**
	 * �Ƴ����ﳵ
	 */
	public int deleteOrderById(String id) {
		String sql="update order_detail set detail_status=0 where DETAIL_ORDER_ID='' and DETAIL_ID =?";
		int i=SqlUtil.executeUpdate(sql, id);
		return i;
		
	}
	
	/**
	 * ������ϵ�����ݶ���ID��ѯ��������
	 * HashMap
	 */
	public List queryDetailsByOrder(String orderId){
		String sql="select dl.*,pt.PRODUCT_NAME,pt.PRODUCT_LARGER_PRICE from order_detail dl left join product pt on dl.DETAIL_PRODUCT_ID=pt.PRODUCT_ID WHERE dl.DETAIL_ORDER_ID=?";
		List<HashMap<String, Object>> list=SqlUtil.executeQuery(sql, orderId);
		return list;
	}
	
	/**
	 * �ύ����
	 */
	public int commentCar(String orderUserId,String orderTotalPrice,String orderComment) {
		String sql="UPDATE order_detail  SET DETAIL_ORDER_ID =?  WHERE DETAIL_USER_ID = ? and DETAIL_ORDER_ID =''";
		String orderId=IdUtil.getDateId();
		SqlUtil.executeUpdate(sql, orderId,orderUserId);
		String sql2="INSERT into order_list(ORDER_ID,ORDER_USER_ID,ORDER_DATE_TIME,ORDER_IS_SEND,ORDER_IS_VALID,ORDER_TOTAL_PRICE,ORDER_STATUS,ORDER_COMMENT)VALUES(?,?,?,1,1,?,1,?)";
		//String datatime=IdUtil.getLongTimeId();
		Date date = new Date();
		int row=SqlUtil.executeUpdate(sql2,orderId,orderUserId,date,orderTotalPrice,orderComment);
		return row;
		
	}
	
	
	

	
}
