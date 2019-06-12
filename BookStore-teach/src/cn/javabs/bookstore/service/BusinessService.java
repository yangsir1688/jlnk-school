package cn.javabs.bookstore.service;

import java.util.List;

import cn.javabs.bookstore.commons.Page;
import cn.javabs.bookstore.entity.Book;
import cn.javabs.bookstore.entity.Category;
import cn.javabs.bookstore.entity.User;

/**
 * 分类的业务逻辑
 * @author Mryang
 * 全部保存  组合键：ctrl+shift+s
 * 首先是一个接口 、  没有具体的实现 只需要去写方法即可
 * 普及：
 * 		在jdk 1.6 中 接口中一定全部都是抽象方法
 * 		在jdk 1.8 中 接口中不一定全部都是抽象方法
 * Eclipse快捷键:
 * 快速修复：  ctrl+1
 * 自动导包  ctrl+shift+o
 * IDEA 快捷键:
 * 		Alt+Enter
 */
public interface BusinessService {

	
//***********************************以下是图书信息管理***************************************************
	
	/**
	 * 添加图书
	 * @param book 参数是  图书对象
	 */
	void addBook(Book book);
	
	/**
	 * 查询所有图书  
	 * @param pagenum 当前页码
	 * @return
	 */
	Page findAllBook(String pagenum);
	
	
	
//***********************************以下是用户注册登录***************************************************	
	
		/**
		 * 用户注册
		 * @param user 参数是用户对象
		 */
		void userRegister(User user);
	
		/**
		 * 用户登录
		 * @param username 参数是用户名
		 * @param password 参数是密码
		 * @return 没有返回值则返回null
		 */
		User userLogin(String username ,String password,String type);
	
	
	
//***********************************以下是图书分类***************************************************	
	/**
	 * 添加分类
	 * @param category
	 */
	void addCategory(Category category);
	
	/**
	 * 根据id查询分类
	 * @param id 参数为分类名称
	 * @return 分类对象
	 */
	
	Category findCategoryById(String id);	
	
	/**
	 * 查询所有分类
	 * 因为是所有，必须有容器存放，故选择集合
	 * 泛型的类型必须是引用数据类型
	 * @return
	 */
	List<Category> findAllCategory();
	/**
	 * 根据id进行删除图书分类
	 * @param categoryId
	 */
	void delCategory(String categoryId);

	/**
	 * 分类修改
	 * @param category
	 */
	void editCategory(Category category);

	/**
	 * 删除图书
	 * @param bookId
	 */
	void delBook(String bookId);

	/**
	 * 根据id进行图书信息的回显
	 * @param bookId
	 * @return
	 */
	Book findBookById(String bookId);

	/**
	 * 修改图书
	 * @param book
	 */
	void editBook(Book book);

	/**
	 * 根据图书分类的id 及分页当前页码进行查询显示图书
	 * @param pagenum
	 * @param categoryId
	 * @return
	 */
	Page findAllBookPageRecords(String pagenum, String categoryId);





	
}
