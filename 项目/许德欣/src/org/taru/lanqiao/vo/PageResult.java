package org.taru.lanqiao.vo;

import java.util.List;

public class PageResult {
	int PageNum;
	int PageSize;
	List list;
	int total;
	int pages;
	public int getPageNum() {
		return PageNum;
	}
	public void setPageNum(int pageNum) {
		PageNum = pageNum;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
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
	
}
