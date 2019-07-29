package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.service.productServiceImpl;
import org.taru.lanqiao.util.JsonWriter;
import org.taru.lanqiao.util.StringUtil;
import org.taru.lanqiao.vo.JsonResult;

@WebServlet("/api/product/update")
public class updateProductServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String id=request.getParameter("productId");
		String code=request.getParameter("productCode");
		String name=request.getParameter("productName");
		String standard=request.getParameter("productStandard");
		String smallunit=request.getParameter("productSmallUnit");
	    BigDecimal smallprice1=new BigDecimal(StringUtil.isnull(request.getParameter("productSmallPrice")).toString());
		String  largerunit=request.getParameter("productLargerUnit");
		String largerprice=request.getParameter("productLargerPrice");
		BigDecimal largerprice1=new BigDecimal(StringUtil.isnull(largerprice).toString());
		String categoryid=request.getParameter("productCategoryId");
		String brandid=request.getParameter("productBrandId");
		String photo=request.getParameter("productPhoto");
		String isscale=request.getParameter("productIsSale");
		Byte isscale1=Byte.parseByte(isscale);
		String islack=request.getParameter("productIsLack");
		Byte islack1=Byte.parseByte(islack);
		String status=request.getParameter("productStatus");
		Byte status1=Byte.parseByte(status);
		String order=request.getParameter("productOrder");
		Integer order1=Integer.parseInt(order);
		String datetime=request.getParameter("productDateTime");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		Date datetime1=null;
		try {
			datetime1 = format.parse(datetime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String largerstandard=request.getParameter("productLargerStandard");
		String suggestprice=request.getParameter("productSuggestPrice");
		BigDecimal suggestprice1=new BigDecimal(StringUtil.isnull(suggestprice).toString());
		Product product=new Product();
		product.setProductBrandId(brandid);
		product.setProductCategoryId(categoryid);
		product.setProductCode(code);
		product.setProductDateTime(datetime1);
		product.setProductId(id);
		product.setProductIsLack(islack1);
		product.setProductIsSale(isscale1);
		product.setProductLargerPrice(largerprice1);
		product.setProductLargerStandard(largerstandard);
		product.setProductLargerUnit(largerunit);
		product.setProductName(name);
		product.setProductOrder(order1);
		product.setProductPhoto(photo);
		product.setProductSmallPrice(smallprice1);
		product.setProductSmallUnit(smallunit);
		product.setProductStandard(standard);
		product.setProductStatus(status1);
		product.setProductSuggestPrice(suggestprice1);
		productServiceImpl impl=new productServiceImpl();
		int num=impl.update(product);
		JsonResult result=null;
		try {
			if(num>0) {
				result=new JsonResult("200","³É¹¦");
			}
		}catch(Exception e) {
			e.printStackTrace();
			result=new JsonResult("404","Ê§°Ü");
		}
		JsonWriter.writer(response, result);
	}
}
