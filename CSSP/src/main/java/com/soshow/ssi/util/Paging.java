package com.soshow.ssi.util;

public class Paging {
	private int pageNo;
	private int pageSize;
	private int startRow;
	private int endRow;
	
	public Paging() {
		startRow=0;
		endRow=Integer.MAX_VALUE;
	}
	
	public Paging(int pageNo,int pageSize) {
		this.pageNo=pageNo;
		this.pageSize=pageSize;
		init();
	}
	
	private void init(){
		startRow= (pageNo-1)*pageSize;
		endRow= pageNo*pageSize;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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
	
}
