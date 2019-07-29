package org.taru.lanqiao.model;

import java.util.List;

public class PageProduct {
		int pageNum;
		int pageSize;
		int size;
		int startRow;
		int endRow;
		int total;
		int pages;
		List<Product> list;
//	public PageProduct(int pageNum, int pageSize, int size, int startRow, int endRow, int total, int pages, List<Product> list) {
//		super();
//		this.pageNum = pageNum;
//		this.pageSize = pageSize;
//		this.size = size;
//		this.startRow = startRow;
//		this.endRow = endRow;
//		this.total = total;
//		this.pages = pages;
//		this.list = list;
//	}

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
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
	public List getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
}
