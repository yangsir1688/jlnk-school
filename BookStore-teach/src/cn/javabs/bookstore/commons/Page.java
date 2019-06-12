package cn.javabs.bookstore.commons;

import java.util.List;

/**
 * 分页显示
 * @author Mryang
 *  startIndex 索引开始的地方
 *  pageSize 	  每页显示多少条
 *  totalPage  总页数
 *  totalRecords  总记录条数   代表有多少本书
 *  因为limit需要俩参数：
 *  	 一个是索引开始的地方、	 startIndex
 *  	 另一个是每页显示多少条	 pageSize
 */
public class Page {
	
	// 条数
	private List records;
	
	// 每页显示多少条
	private int pageSize = 3;
	
	// 当前页码
	private int currentPageNum;
	// 总页数
	private int totalPage;
	// 上一页
	private int prePageNum;
	// 下一页
	private int nextPageNum;
	
	// 每页开始记录的索引
	private int startIndex;
	
	// 总记录条数
	private int totalRecords;
	
	private String url;
	
	/**
	 * 有参数的构造函数
	 *  		currentPageNum 参数是 当前页码
	 * @param  totalRecords  参数是 总记录条数
	 */
	//				5					7
	public Page(int currentPagenum, int totalRecords) {
		//			7			7
		this.totalRecords = totalRecords;
		//			5				5
		this.currentPageNum = currentPagenum;
		// 未知数 =   6 / 3  = 2  余数 0
		
		// 总页数 =     总的条数(7) 取模 当前显示条数(3) == 0 ? 符合  显示 总的条数(7)/除 当前显示条数(3)=2  ： 否则  总的条数(7) 除  当前显示条数(3)=2+1
		totalPage = totalRecords%pageSize  ==0?totalRecords/pageSize    :   totalRecords/pageSize+1;
		
		
		// 开始索引  =  （当前页码 -1 ） * 3  |举个栗子： （1-1）*3  = 0； （2-1）*3 = 3
		startIndex = (currentPageNum-1)*pageSize;
		
		
	}
	
	public List getRecords() {
		return records;
	}
	public void setRecords(List records) {
		this.records = records;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPrePageNum() {
		//上一页 =  当前页码 -1  要求大于0 才拥有上一页，否则则1 
		prePageNum = currentPageNum - 1>0?currentPageNum - 1:1;
		return prePageNum;
	}
	public void setPrePageNum(int prePageNum) {
		
		
		this.prePageNum = prePageNum;
	}
	public int getNextPageNum() {
		//下一页 =  当前页码 + 1  如果大于总页数   
		nextPageNum = currentPageNum + 1 >totalPage?totalPage : currentPageNum + 1;
		return nextPageNum;
	}
	public void setNextPageNum(int nextPageNum) {
		
		
		this.nextPageNum = nextPageNum;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Page [records=" + records + ", pageSize=" + pageSize
				+ ", currentPageNum=" + currentPageNum + ", totalPage="
				+ totalPage + ", prePageNum=" + prePageNum + ", nextPageNum="
				+ nextPageNum + ", startIndex=" + startIndex
				+ ", totalRecords=" + totalRecords + ", url=" + url + "]";
	}
	
	
}
