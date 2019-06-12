package cn.javabs.bookstore.dao;

import java.util.List;

import cn.javabs.bookstore.entity.Book;

public interface BookDao {

	void insertBook(Book book);

	/**
	 * 查询所有书的数量
	 * @return 统计的数量
	 */
	int findAllBookNumber();

	
	List<Book> findAllBookRecords(int startIndex,int pageSize);

	void remove(String bookId);

	Book getBookById(String bookId);

	void updateBook(Book book);

	int findPageBookNumber(String categoryId);

	List<Book> findPageBooks(int startIndex, int pageSize, String categoryId);
	 
	
	
}
