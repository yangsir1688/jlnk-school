package cn.javabs.bookstore.commons;

import java.util.HashMap;
import java.util.Map;

import cn.javabs.bookstore.entity.Book;
/**
 * 购物车
 * @author Mryang
 *
 */
public class Cart {

	//   key    购物项对应的书籍的Id
	//	value	购物项
	private HashMap<String, CartItem>  items = new HashMap<String, CartItem>();
	
	private int totalQuantity;//总计数量
	
	private float amount; // 付款项目 ，总金额

	public HashMap<String, CartItem> getItems() {
		return items;
	}

	public void setItems(HashMap<String, CartItem> items) {
		this.items = items;
	}

	/**
	 * 获取总数量
	 * @return
	 */
	public int getTotalQuantity() {
		totalQuantity = 0; // 初始化值为0
		//      类型      变量         需要被循环的集合
		// for (List  list : lists)
		for(Map.Entry<String, CartItem> item:items.entrySet()){
			totalQuantity += item.getValue().getQuantity();
		}
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public float getAmount() {
		amount = 0;
		for(Map.Entry<String, CartItem> item:items.entrySet()){
			amount += item.getValue().getTotalPrice();
		}
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	/**
	 * 添加图书到购物车里（其实质就是加了一个购物项）
	 * @param book
	 */
	public void addBook(Book book){
		// 进行判断：  集合中有没有包含的键   （键就是书的id） 目前是已包含
		if(items.containsKey(book.getId())){
			// 图书已存在
			CartItem item = items.get(book.getId());
			// 在购物车的原本数量上+1
			item.setQuantity(item.getQuantity()+1);
		}else{
			// 图书不存在
				// 根据图书进行创建购物项
				CartItem item = new CartItem(book);
				// 之前的购物项是空的， 加一个
				item.setQuantity(1);
				items.put(book.getId(), item);
		}
	}
}