package org.taru.lanqiao.model;

import java.math.BigDecimal;
import java.util.Date;

public class Detil {
	private String detailId;
	private String detailProductId;
	private int detailProductCount;
	private String productName;
	private String detailProductUnit;
	private Product product;
	private BigDecimal detailProductPrice;
	private BigDecimal detailTotalPrice;
	private String detailComment;
	private int detailStatus;
	private String detailOrderId;
	private String detailUserId;
	private Date detailDateTime;
	public BigDecimal getDetailProductPrice() {
		return detailProductPrice;
	}
	public void setDetailProductPrice(BigDecimal detailProductPrice) {
		this.detailProductPrice = detailProductPrice;
	}
	public BigDecimal getDetailTotalPrice() {
		return detailTotalPrice;
	}
	public void setDetailTotalPrice(BigDecimal detailTotalPrice) {
		this.detailTotalPrice = detailTotalPrice;
	}
	public String getDetailComment() {
		return detailComment;
	}
	public void setDetailComment(String detailComment) {
		this.detailComment = detailComment;
	}
	public int getDetailStatus() {
		return detailStatus;
	}
	public void setDetailStatus(int detailStatus) {
		this.detailStatus = detailStatus;
	}
	public String getDetailOrderId() {
		return detailOrderId;
	}
	public void setDetailOrderId(String detailOrderId) {
		this.detailOrderId = detailOrderId;
	}
	public String getDetailUserId() {
		return detailUserId;
	}
	public void setDetailUserId(String detailUserId) {
		this.detailUserId = detailUserId;
	}
	public Date getDetailDateTime() {
		return detailDateTime;
	}
	public void setDetailDateTime(Date detailDateTime) {
		this.detailDateTime = detailDateTime;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getDetailId() {
		return detailId;
	}
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	public String getDetailProductId() {
		return detailProductId;
	}
	public void setDetailProductId(String detailProductId) {
		this.detailProductId = detailProductId;
	}
	public int getDetailProductCount() {
		return detailProductCount;
	}
	public void setDetailProductCount(int detailProductCount) {
		this.detailProductCount = detailProductCount;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDetailProductUnit() {
		return detailProductUnit;
	}
	public void setDetailProductUnit(String detailProductUnit) {
		this.detailProductUnit = detailProductUnit;
	}
	
}
