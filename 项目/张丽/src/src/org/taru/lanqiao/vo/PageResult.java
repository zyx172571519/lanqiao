package org.taru.lanqiao.vo;

import java.util.List;

public class PageResult {
	int pageNum;
	int pageSize;
	List list;
	int total;
	int pages;
	public List getList() {
		return list;
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getPages() {
		return pages;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setList(List list) {
		this.list = list;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
