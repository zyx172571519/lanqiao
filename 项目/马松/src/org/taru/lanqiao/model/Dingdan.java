package org.taru.lanqiao.model;

import java.util.List;

public class Dingdan {

	private String detailId;
	private String detailTotalPrice;
	private String detailUserId;
	private String detailDateTime;
	private String detailComment;
	private String detailStatus;
	private String detailOrderId;
	private String detailProductPrice;
	private String detailProductCount;
	private String detailProductUnit;
	private String detailProductId;
	private String orderId;
	private String orderUserId;
	private String orderDateTime;
	private String orderIsSend;
	private String orderIsValid;
	private String orderTotalPrice;
	private String orderStatus;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderUserId() {
		return orderUserId;
	}
	public void setOrderUserId(String orderUserId) {
		this.orderUserId = orderUserId;
	}
	public String getOrderDateTime() {
		return orderDateTime;
	}
	public void setOrderDateTime(String orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	public String getOrderIsSend() {
		return orderIsSend;
	}
	public void setOrderIsSend(String orderIsSend) {
		this.orderIsSend = orderIsSend;
	}
	public String getOrderIsValid() {
		return orderIsValid;
	}
	public void setOrderIsValid(String orderIsValid) {
		this.orderIsValid = orderIsValid;
	}
	public String getOrderTotalPrice() {
		return orderTotalPrice;
	}
	public void setOrderTotalPrice(String orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderComment() {
		return orderComment;
	}
	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}
	private String orderComment;
    int total;
    List user;
    
    public List getUser() {
		return user;
	}
	public void setUser(List user) {
		this.user = user;
	}
	public String getDetailComment() {
		return detailComment;
	}
	public void setDetailComment(String detailComment) {
		this.detailComment = detailComment;
	}
	public String getDetailStatus() {
		return detailStatus;
	}
	public void setDetailStatus(String detailStatus) {
		this.detailStatus = detailStatus;
	}
	public String getDetailOrderId() {
		return detailOrderId;
	}
	public void setDetailOrderId(String detailOrderId) {
		this.detailOrderId = detailOrderId;
	}
	public String getDetailProductPrice() {
		return detailProductPrice;
	}
	public void setDetailProductPrice(String detailProductPrice) {
		this.detailProductPrice = detailProductPrice;
	}
	public String getDetailProductCount() {
		return detailProductCount;
	}
	public void setDetailProductCount(String detailProductCount) {
		this.detailProductCount = detailProductCount;
	}
	public String getDetailProductUnit() {
		return detailProductUnit;
	}
	public void setDetailProductUnit(String detailProductUnit) {
		this.detailProductUnit = detailProductUnit;
	}
	public String getDetailProductId() {
		return detailProductId;
	}
	public void setDetailProductId(String detailProductId) {
		this.detailProductId = detailProductId;
	}
	int pages;
	List list;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getDetailId() {
		return detailId;
	}
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	public String getDetailTotalPrice() {
		return detailTotalPrice;
	}
	public void setDetailTotalPrice(String detailTotalPrice) {
		this.detailTotalPrice = detailTotalPrice;
	}
	public String getDetailUserId() {
		return detailUserId;
	}
	public void setDetailUserId(String detailUserId) {
		this.detailUserId = detailUserId;
	}
	public String getDetailDateTime() {
		return detailDateTime;
	}
	public void setDetailDateTime(String detailDateTime) {
		this.detailDateTime = detailDateTime;
	}
	
}
