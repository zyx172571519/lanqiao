package org.taru.lanqiao.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.util.SqlUtil;
import org.taru.lanqiao.util.StringUtil;
import org.taru.lanqiao.vo.PageResult;

public class productDaoImpl {
/**
 * ÐÞ¸ÄÉÌÆ·
 * @param product
 * @return
 */
public int updateProduct(Product product) {
		String sql = "update product set PRODUCT_CODE=?,PRODUCT_NAME=?,PRODUCT_STANDARD=?,PRODUCT_SMALL_UNIT=?,PRODUCT_SMALL_PRICE=?,PRODUCT_LARGER_UNIT=?,PRODUCT_LARGER_PRICE=?,PRODUCT_CATEGORY_ID=?,PRODUCT_BRAND_ID=?,PRODUCT_PHOTO=?,PRODUCT_IS_SALE=?,PRODUCT_IS_LACK=?,PRODUCT_STATUS=?,PRODUCT_ORDER=?,PRODUCT_DATE_TIME=?,PRODUCT_LARGER_STANDARD=?,PRODUCT_SUGGEST_PRICE=? where PRODUCT_ID=?";
		int i = SqlUtil.executeUpdate(sql, product.getProductCode(), product.getProductName(),
				product.getProductStandard(), product.getProductSmallUnit(), product.getProductSmallPrice(),
				product.getProductLargerUnit(), product.getProductLargerPrice(), product.getProductCategoryId(),
				product.getProductBrandId(), product.getProductPhoto(), product.getProductIsSale(),
				product.getProductIsLack(), product.getProductStatus(), product.getProductOrder(),
				product.getProductDateTime(), product.getProductLargerStandard(), product.getProductSuggestPrice(),
				product.getProductId());
		return i;
	}

}
