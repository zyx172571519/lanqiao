package org.taru.lanqiao.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.taru.lanqiao.model.Product;
import org.taru.lanqiao.model.User;

public class shopCar {
	private String detailId;

    private String detailProductId;

    private Integer detailProductCount;

    private String detailProductUnit;

    private BigDecimal detailProductPrice;

    private BigDecimal detailTotalPrice;

    private String detailComment;

    private Byte detailStatus;

    private String detailOrderId;

    private String detailUserId;

    private Date detailDateTime;
    
	List<Product> list;
	
	//User user;

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

	public Integer getDetailProductCount() {
		return detailProductCount;
	}

	public void setDetailProductCount(Integer detailProductCount) {
		this.detailProductCount = detailProductCount;
	}

	public String getDetailProductUnit() {
		return detailProductUnit;
	}

	public void setDetailProductUnit(String detailProductUnit) {
		this.detailProductUnit = detailProductUnit;
	}

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

	public Byte getDetailStatus() {
		return detailStatus;
	}

	public void setDetailStatus(Byte detailStatus) {
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

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

}
