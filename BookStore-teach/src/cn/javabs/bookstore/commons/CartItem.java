package cn.javabs.bookstore.commons;

import cn.javabs.bookstore.entity.Book;
/**
 * 购物车中的购物项
 * @author Mryang
 *
 */
public class CartItem {

	private Book book;
	
	private int quantity;// 小计数量
	
	private float totalPrice;// 小计金额
	

	/**
	 * 自定义一个构造函数
	 * 快捷键:alt+shift+s  o  --  代表的是有参数的
	 * @param book
	 */
	public CartItem(Book book) {
		this.book = book;
	}

	// 生成了getter和setter方法
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//小计 = 图书单价  * 数量
	public float getTotalPrice() {
		return book.getPrice()*quantity;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
