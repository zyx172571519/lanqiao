package org.taru.lanqiao.model;

public class ShopCar {
	
	String detailProductId;
	String detailProductCount;
	String detailProductUnit;
	String detailProductPrice;
	String detailComment;
	String detailUserId;
	public ShopCar(String detailProductId, String detailProductCount, String detailProductUnit,
			String detailProductPrice, String detailComment, String detailUserId) {
		super();
		this.detailProductId = detailProductId;
		this.detailProductCount = detailProductCount;
		this.detailProductUnit = detailProductUnit;
		this.detailProductPrice = detailProductPrice;
		this.detailComment = detailComment;
		this.detailUserId = detailUserId;
	}

	public String getDetailProductId() {
		return detailProductId;
	}
	public void setDetailProductId(String detailProductId) {
		this.detailProductId = detailProductId;
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
	public String getDetailProductPrice() {
		return detailProductPrice;
	}
	public void setDetailProductPrice(String detailProductPrice) {
		this.detailProductPrice = detailProductPrice;
	}
	public String getDetailComment() {
		return detailComment;
	}
	public void setDetailComment(String detailComment) {
		this.detailComment = detailComment;
	}
	public String getDetailUserId() {
		return detailUserId;
	}
	public void setDetailUserId(String detailUserId) {
		this.detailUserId = detailUserId;
	}


}
