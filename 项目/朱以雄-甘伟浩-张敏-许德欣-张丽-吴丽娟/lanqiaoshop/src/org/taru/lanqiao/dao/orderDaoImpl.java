package org.taru.lanqiao.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.taru.lanqiao.model.Detil;
import org.taru.lanqiao.model.Order;
import org.taru.lanqiao.model.OrderList;
import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;

public class orderDaoImpl {
	
	/**
	 * 
	 * @param orderid
	 * @订单发货
	 */
	public int orderSend(String orderid) {
		String sql="update order_list set ORDER_IS_SEND=1 where ORDER_ID=?";
		int row=SqlUtil.executeUpdate(sql, orderid);
		return row;
	}
	
	/**
	 * 
	 * @param orderid
	 * @订单作废
	 */
	public int deleteOrderById(String orderid) {
		String sql="update order_list set ORDER_STATUS=0 where ORDER_ID=?";
		int row=SqlUtil.executeUpdate(sql, orderid);
		return row;
	}
	
	/**
	 * 
	 * @param orderid
	 * @导出订单
	 */
	public OrderList queryOrderListById(String orderid) {
		String sql="select * from order_list where ORDER_ID=?";
		List<HashMap<String,Object>> list=SqlUtil.executeQuery(sql, orderid);
		OrderList orderlist=null;
		if(list.size()>0) {
			orderlist=new OrderList();
			orderlist.setOrderId(StringUtil.valueOf(list.get(0).get("ORDER_ID")));
			orderlist.setOrderUserId(StringUtil.valueOf(list.get(0).get("ORDER_USER_ID")));
			orderlist.setOrderIsSend(Byte.parseByte(StringUtil.valueOf(list.get(0).get("ORDER_IS_SEND"))));
			orderlist.setOrderIsValid(Byte.parseByte(StringUtil.valueOf(list.get(0).get("ORDER_IS_VALID"))));
			orderlist.setOrderStatus(Byte.parseByte(StringUtil.valueOf(list.get(0).get("ORDER_STATUS"))));
			//double ordertotalprice=DoubleTo.value(StringUtil.valueOf(list.get(0).get("ORDER_TOTAL_PRICE")));
			//orderlist.setOrderTotalPrice(ordertotalprice);
		}
		return orderlist;
	}
	
	/**
	 * 查询历史订单
	 * @author Administrator
	 *
	 */
		public Order queryHistory(String userid) throws Exception {
			String sql="select * from order_list where ORDER_USER_ID=?";
			ArrayList<HashMap<String,Object>> list=SqlUtil.executeQuery(sql,userid);
			Order order=null;
			if(list.size()>0) {
				order=new Order();
				order.setOrderUserId(list.get(0).get("ORDER_USER_ID").toString());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
				order.setOrderDateTime(format.parse(list.get(0).get("ORDER_DATE_TIME").toString()));
				order.setOrderComment(list.get(0).get("ORDER_COMMENT").toString());
			}
			return order;
		}
		
		/**
		 * 根据订单id查询订单详情
		 * @author Administrator
		 *
		 */
			public List<Detil> queryDetailByOrderId(String orderid) throws Exception{
				String sql="select dl.*,pt.* from order_detail dl left join product pt on dl.DETAIL_PRODUCT_ID=pt.PRODUCT_ID where DETAIL_ORDER_ID=?";
				ArrayList<HashMap<String,Object>> list=SqlUtil.executeQuery(sql, orderid);
				List<Detil> details =new ArrayList<Detil>();
				if(list !=null && list.size()>0) {
					for(Map<String,Object> map:list) {
						Detil detail=new Detil();
						detail.setDetailId(StringUtil.valueOf(map.get("DETAIL_ID")));
						detail.setDetailProductId(StringUtil.valueOf(map.get("DETAIL_PRODUCT_ID")));
						Integer pc=Integer.parseInt(StringUtil.valueOf(map.get("DETAIL_PRODUCT_COUNT")));
						detail.setDetailProductCount(pc);
						detail.setDetailProductUnit(StringUtil.valueOf(map.get("DETAIL_PRODUCT_UNIT")));
						BigDecimal detailProductPrice=new BigDecimal(StringUtil.isnull(map.get("DETAIL_PRODUCT_PRICE")).toString());
						detail.setDetailProductPrice(detailProductPrice);
						BigDecimal detailTotalPrice=new BigDecimal(StringUtil.isnull(map.get("DETAIL_TOTAL_PRICE")).toString());
						detail.setDetailTotalPrice(detailTotalPrice);
						detail.setDetailComment(StringUtil.valueOf(map.get("DETAIL_COMMENT")));
						Integer detailStatus=Integer.parseInt(StringUtil.valueOf(map.get("DETAIL_STATUS")));
						detail.setDetailStatus(detailStatus);
						detail.setDetailOrderId(StringUtil.valueOf(map.get("DETAIL_ORDER_ID")));
						detail.setDetailUserId(StringUtil.valueOf(map.get("DETAIL_USER_ID")));
						SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
						detail.setDetailDateTime(format.parse(map.get("DETAIL_DATE_TIME").toString()));
						Product product=new Product();
						product.setProductId(StringUtil.valueOf(map.get("PRODUCT_ID")));
						product.setProductCode(StringUtil.valueOf(map.get("PRODUCT_CODE")));
						product.setProductName(StringUtil.valueOf(map.get("PRODUCT_NAME")));
						product.setProductStandard(StringUtil.valueOf(map.get("PRODUCT_STANDARD")));
						product.setProductSmallUnit(StringUtil.valueOf(map.get("PRODUCT_SMALL_UNIT")));
						BigDecimal productSmallPrice=new BigDecimal(StringUtil.valueOf(map.get("PRODUCT_SMALL_PRICE")).toString());
						product.setProductSmallPrice(productSmallPrice);
						product.setProductLargerUnit(StringUtil.valueOf(map.get("PRODUCT_LARGER_UNIT")));
						BigDecimal productLargerPrice=new BigDecimal(StringUtil.valueOf(map.get("PRODUCT_LARGER_PRICE")).toString());
						product.setProductLargerPrice(productLargerPrice);
						product.setProductCategoryId(StringUtil.valueOf(map.get("PRODUCT_CATEGORY_ID")));
						product.setProductBrandId(StringUtil.valueOf(map.get("PRODUCT_BRAND_ID")));
						product.setProductPhoto(StringUtil.valueOf("PRODUCT_PHOTO"));
						Byte isscale=Byte.parseByte(StringUtil.valueOf(map.get("PRODUCT_IS_SALE")));
						product.setProductIsSale(isscale);
						Byte islack=Byte.parseByte(StringUtil.valueOf(map.get("PRODUCT_IS_LACK")));
						product.setProductIsLack(islack);
						Byte status=Byte.parseByte(StringUtil.valueOf(map.get("PRODUCT_STATUS")));
						product.setProductStatus(status);
						Integer productOrder=Integer.parseInt(StringUtil.valueOf(map.get("PRODUCT_ORDER")));
						product.setProductOrder(productOrder);
						SimpleDateFormat format1 = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
						product.setProductDateTime(format1.parse(map.get("PRODUCT_DATE_TIME").toString()));
						product.setProductLargerStandard(StringUtil.valueOf(map.get("PRODUCT_LARGER_STANDARD")));
						BigDecimal productSuggestPrice=new BigDecimal(StringUtil.valueOf(map.get("PRODUCT_SUGGEST_PRICE")).toString());
						product.setProductSuggestPrice(productSuggestPrice);
						detail.setProduct(product);
						details.add(detail);
						
					}
				}
				
				return details;
			
		}
}
