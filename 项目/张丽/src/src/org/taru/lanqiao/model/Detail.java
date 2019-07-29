package org.taru.lanqiao.model;

public class Detail {
	String detailId;
	String detailProductId;
	String product_name;
	Product product; //多对1的关联关系的配置
	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	
	
}
