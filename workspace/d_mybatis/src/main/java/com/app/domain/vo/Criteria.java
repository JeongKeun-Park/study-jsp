package com.app.domain.vo;

public class Criteria {
	private int page;
	private int pageCount;
	private int startPage;
	private int endPage;
	private int rowCount;
	private int startRow;
	private int endRow;
	private int realEnd;
	private boolean prev, next;
	
	public Criteria(int page, int total) {
		this.rowCount = 10;
		this.pageCount = 10;
		
		this.page = page == 0 ? 1 : page;
		this.endPage = (int)(Math.ceil(this.page / (double)pageCount)) * pageCount;
		this.startPage = endPage - (pageCount - 1);
		this.realEnd = (int)Math.ceil(total / (double)rowCount);
		this.endPage = this.endPage > realEnd ? realEnd : endPage;
		this.endPage = this.endPage == 0 ? 1 : this.endPage;
		
		this.endRow = rowCount * this.page;
		this.startRow = endRow - (rowCount - 1);
		this.prev = startPage > 1;
		this.next = realEnd != endPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
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
	
	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pageCount=" + pageCount + ", startPage=" + startPage + ", endPage="
				+ endPage + ", rowCount=" + rowCount + ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}
}
