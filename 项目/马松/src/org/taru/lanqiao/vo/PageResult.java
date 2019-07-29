package org.taru.lanqiao.vo;

import java.util.List;

public class PageResult {
		int  pageNum;
		int pageSize;
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
		int total;
		int pages;
		List  list;
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
		public List getList() {
			return list;
		}
		public void setList(List list) {
			this.list = list;
		}
	
}
