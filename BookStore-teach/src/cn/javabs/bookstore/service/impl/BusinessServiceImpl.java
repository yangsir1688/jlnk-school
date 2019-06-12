package cn.javabs.bookstore.service.impl;

import java.util.List;
import java.util.UUID;

import cn.javabs.bookstore.dao.BookDao;
import cn.javabs.bookstore.dao.CategoryDao;
import cn.javabs.bookstore.dao.UserDao;
import cn.javabs.bookstore.dao.impl.BookDaoImpl;
import cn.javabs.bookstore.dao.impl.CategoryDaoImpl;
import cn.javabs.bookstore.dao.impl.UserDaoImpl;
import cn.javabs.bookstore.service.BusinessService;
import cn.javabs.bookstore.commons.Page;
import cn.javabs.bookstore.entity.Book;
import cn.javabs.bookstore.entity.Category;
import cn.javabs.bookstore.entity.User;

/**
 * 业务逻辑层的实现类
 * @author Mryang
 * 原因是  实现类必须要覆写 接口中全部的方法
 */
	public class BusinessServiceImpl implements BusinessService {
	
	
	BookDao bookDao = new BookDaoImpl();//多态
	UserDao userDao = new UserDaoImpl();//多态
	CategoryDao categoryDao = new CategoryDaoImpl();//多态
	
//***********************************以下是图书信息***************************************************
	public void addBook(Book book) {
		book.setId(UUID.randomUUID().toString());
		bookDao.insertBook(book);
	}

	
	
	public void delBook(String bookId) {
		bookDao.remove(bookId);
	}
	
	public Book findBookById(String bookId) {
		Book book = bookDao.getBookById(bookId);
		return book;
	}
	
	public void editBook(Book book) {
		bookDao.updateBook(book);
		
	}

	/**
	 * 查询所有的图书信息
	 * 从哪里传过来的？ jsp-- servlet --service -serviceImpl 
	 * 再去那里? dao- daoImpl 
	 * @param pagenum 前台传入的页码
	 */
	public Page findAllBook(String pagenum) {
		
		int currentPagenum = 1;
		/**
		 * 严谨！！！
		 **  
		 */
		if(pagenum != null){
			//currentPagenum 是 前台jsp 传入给servlet ，此时变成了字符串 故此处需要转换成为int
			currentPagenum = Integer.parseInt(pagenum);
		}
		// 拿到总的记录条数
		//  7
		int totalRecords = bookDao.findAllBookNumber();
						 
		Page page = new Page(currentPagenum, totalRecords);
		/*
		 * 分页的条数
		 */
		List<Book> records = bookDao.findAllBookRecords(page.getStartIndex(), page.getPageSize());
		// 把分页条数 封装到page里去
		page.setRecords(records);
		
		System.out.println("page = " +page);
		
		return page;
	}
	
	@Override
	public Page findAllBookPageRecords(String pagenum, String categoryId) {
		int currentPagenum = 1;
		/**
		 * 严谨！！！
		 **  
		 */
		if(pagenum != null){
			//currentPagenum 是 前台jsp 传入给servlet ，此时变成了字符串 故此处需要转换成为int
			currentPagenum = Integer.parseInt(pagenum);
		}
		/**
		 * ☆  通过bookDao 的某个方法（之前也是不存在的！） 传入分类id  返回的4条记录  
		 * 		把这4条记录放到records中，因为records是list集合
		 */
		int totalRecords = bookDao.findPageBookNumber(categoryId);
						 
		Page page = new Page(currentPagenum, totalRecords);
		/*
		 * 分页的条数
		 */
		List<Book> records = bookDao.findPageBooks(page.getStartIndex(), page.getPageSize(),categoryId);
		// 把分页条数 封装到page里去
		page.setRecords(records);
		
		System.out.println("page = " +page);
		
		return page;
	}

	
//***********************************以下是图书分类***************************************************
	/**
	 * 需要的 是一个分类的对象  Category  只要一个
	 */
	public void addCategory(Category category) {
		category.setId(UUID.randomUUID().toString());
		categoryDao.save(category);
	}


	public Category findCategoryById(String id) {
		return categoryDao.getCategoryById(id);
	}

	
	public List<Category> findAllCategory() {
		return categoryDao.getAllCategory();
	}

	
	public void delCategory(String categoryId) {
		categoryDao.removeCategory(categoryId);
		
	}

	public void editCategory(Category category) {
		categoryDao.updateCategory(category);
		
	}
	//***********************************以下是用户注册登录***************************************************	
	public void userRegister(User user) {
		user.setId(UUID.randomUUID().toString());
		System.out.println("service中的user是"+user);
		userDao.save(user);
	}



	public User userLogin(String username, String password,String type) {
		return userDao.login(username,password,type);
	}



	





	


	

	


	




	
	
}
