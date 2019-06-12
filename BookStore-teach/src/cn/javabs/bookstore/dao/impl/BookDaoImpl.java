package cn.javabs.bookstore.dao.impl;

import java.sql.SQLException;
import java.util.List;

import cn.javabs.bookstore.utils.DbcpUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.javabs.bookstore.dao.BookDao;
import cn.javabs.bookstore.entity.Book;
import cn.javabs.bookstore.exception.AddBookException;
import cn.javabs.bookstore.exception.QueryBookException;

/**
 * 图书的数据访问层接口的实现类
 * @author Mryang
 *
 */
public class BookDaoImpl implements BookDao {

	/**
	 * 为了获取数据源、 因为数据源会自己获取连接
	 * qr 拿到了连接
	 * 			|---可以 执行 插入语句、查询语句、、、、
	 */
	QueryRunner qr = new QueryRunner(DbcpUtils.getDataSource());
	/**
	 * 插入图书
	 */
	public void insertBook(Book book) {
		try {
			qr.update("insert into book(id,name,description,author,publish,price,path,photoname,categoryId) values (?,?,?,?,?,?,?,?,?)",
					book.getId(),
					book.getName(),
					book.getDescription(),
					book.getAuthor(),
					book.getPublish(),
					book.getPrice(),
					book.getPath(),
					book.getPhotoName(),
					book.getCategoryId()
					);
		} catch (SQLException e) {
			throw new AddBookException(e);
/*			throw new RuntimeException(e);
*/		}
	}
	/**
	 * 查询数据库中的书的数量
	 * 返回的是整数
	 */
	public int findAllBookNumber() {
		try {
			Object obj = qr.query("select count(*) from book", new ScalarHandler(1));
			Long num = (Long) obj;
			return num.intValue();
		} catch (SQLException e) {
			throw new QueryBookException(e);
/*			throw new RuntimeException(e);
*/		}
	}
	/**
	 * 分页语句
	 */
	public List<Book> findAllBookRecords(int startIndex, int pageSize) {
		try {
			List<Book> book  = qr.query("select * from book  limit ?,?", new BeanListHandler<Book>(Book.class),startIndex,pageSize);
			System.out.println("book:"+book);
			return book;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	/**
	 * 删除图书
	 */
	public void remove(String bookId) {
		try {
			qr.update("delete from book where id = ?",bookId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 *  根据id进行图书信息的回显
	 */
	public Book getBookById(String bookId) {
		try {
			Book book = qr.query("select * from book where id = ?", new BeanHandler<Book>(Book.class),bookId);
			return book;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	public void updateBook(Book book) {
		try {
			qr.update("update book set name=?,description=?,author=?,publish=?,price=?,path=?,photoname=?,categoryId=? where id =?",
					
					book.getName(),
					book.getDescription(),
					book.getAuthor(),
					book.getPublish(),
					book.getPrice(),
					book.getPath(),
					book.getPhotoName(),
					book.getCategoryId(),
					book.getId()
					);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	/**
	 * 根据分类id查到的有几条记录
	 */
	@Override
	public int findPageBookNumber(String categoryId) {
		try {
		 Object obj = qr.query("select count(*)  from book where categoryId = ?",new ScalarHandler(1),categoryId);
		 Long num =  (Long) obj;
		 return num.intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 根据分页的从哪里开始、要显示几条、分类的id
	 */
	@Override
	public List<Book> findPageBooks(int startIndex, int pageSize,
			String categoryId) {
		try {
			return qr.query("select *  from book where categoryId = ? limit ?,?",new BeanListHandler<Book>(Book.class),categoryId,startIndex,pageSize);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
