package org.taru.lanqiao.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.service.productServiceImpl;
import org.taru.lanqiao.vo.JsonResult;
import org.taru.lanqiao.util.Constants;
import org.taru.lanqiao.util.JsonWriter;
@WebServlet("/api/insert/product/find")
public class productInsertServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonResult result=null;
		try {
			Product product=new Product();
			//String productId=request.getParameter("productId");
			String productCode=request.getParameter("productCode");
			String productName=request.getParameter("productName");
			String productStandard=request.getParameter("productStandard");
			String productSmallUnit=request.getParameter("productSmallUnit");
			BigDecimal productSmallPrice=BigDecimal.valueOf(Integer.parseInt(request.getParameter("productSmallPrice")));
			String productLargerUnit=request.getParameter("productLargerUnit");
			BigDecimal productLargerPrice=BigDecimal.valueOf(Integer.parseInt(request.getParameter("productLargerPrice")));
			String productCategoryId=request.getParameter("productCategoryId");
			String productBrandId=request.getParameter("productBrandId");
			String productPhoto=request.getParameter("productPhoto");
			Byte productIsSale=Byte.parseByte(request.getParameter("productIsSale"));
			Byte productIsLack=Byte.parseByte(request.getParameter("productIsLack"));
			Byte productStatus=Byte.parseByte(request.getParameter("productStatus"));
			Integer productOrder=Integer.parseInt(request.getParameter("productOrder"));
			//Date productDateTime=Date.parse(Long.parseLong(request.getParameter("productDateTime")));
			String productLargerStandard=request.getParameter("productLargerStandard");
			BigDecimal productSuggestPrice=BigDecimal.valueOf(Integer.parseInt(request.getParameter("productSuggestPrice")));
			//product.setProductId(productId);
			product.setProductCode(productCode);
			product.setProductName(productName);
			product.setProductStandard(productStandard);
			product.setProductSmallUnit(productSmallUnit);
			product.setProductSmallPrice(productSmallPrice);
			product.setProductCategoryId(productCategoryId);
			product.setProductBrandId(productBrandId);
			product.setProductPhoto(productPhoto);
			product.setProductIsSale(productIsSale);
			product.setProductIsLack(productIsLack);
			product.setProductStatus(productStatus);
			product.setProductOrder(productOrder);
			//product.setProductDateTime(productDateTime);
			product.setProductLargerStandard(productLargerStandard);
			product.setProductSuggestPrice(productSuggestPrice);
			product.setProductLargerUnit(productLargerUnit);
			product.setProductLargerPrice(productLargerPrice);
			productServiceImpl serviceImpl=new productServiceImpl();
			int row=serviceImpl.insertProduct("123", product);
			result=new JsonResult(Constants.STATUS_SUCCESS,"³É¹¦",row);
		}catch(Exception e) {
			e.printStackTrace();
			result=new JsonResult(Constants.STATUS_ERROR,"Ê§°Ü");
		}
		JsonWriter.writer(response, result);
	}
}
