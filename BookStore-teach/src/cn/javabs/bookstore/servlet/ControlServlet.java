package cn.javabs.bookstore.servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.javabs.bookstore.commons.Cart;
import cn.javabs.bookstore.commons.CartItem;
import cn.javabs.bookstore.commons.Page;
import cn.javabs.bookstore.service.BusinessService;
import cn.javabs.bookstore.service.impl.BusinessServiceImpl;
import cn.javabs.bookstore.utils.SetPhotoPath;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import cn.javabs.bookstore.entity.Book;
import cn.javabs.bookstore.entity.Category;
import cn.javabs.bookstore.entity.User;

/**
 * 后台的Servlet
 * @author Mryang
 */
@WebServlet("/servlet/ControlServlet")
public class ControlServlet extends HttpServlet {

	BusinessService s = new BusinessServiceImpl();

	Book book = new Book();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// -----------------------------这是解决中文编码乱码的解决方案--------------------

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// -----------------------------------------------------------------------

		// 接收参数op
		String op = request.getParameter("op");

		// 如果字符串addCategory 等于 op的值 则执行25行
		// equals 判断是否相等
		if ("addCategory".equals(op)) {
			addCategory(request, response);
			// 如果传过来的参数是“findAllCategory” 与 op的值相同
		} else if ("showBookDetails".equals(op)) {
			showBookDetails(request, response);
		} else if ("showIndex".equals(op)) {
			showIndex(request, response);
		} else if ("showCategoryBooks".equals(op)) {
			showCategoryBooks(request, response);
		} else if ("buyBook".equals(op)) {
			buyBook(request, response);
		} else if ("changeNum".equals(op)) {
			changeNum(request, response);
		} else if("delOneItem".equals(op)){
			delOneItem(request,response);
		}else if ("findAllCategory".equals(op)) {
			findAllCategory(request, response);
		} else if ("userRegister".equals(op)) {
			userRegister(request, response);
		} else if ("userLogin".equals(op)) {
			userLogin(request, response);
		} else if ("logout".equals(op)) {
			logout(request, response);
		} else if ("addBookView".equals(op)) {
			addBookView(request, response);
		} else if ("addBook".equals(op)) {
			addBook(request, response);
		} else if ("showBook".equals(op)) {
			showBook(request, response);
		} else if ("delCategory".equals(op)) {
			delCategory(request, response);
		} else if ("editCategoryView".equals(op)) {
			editCategoryView(request, response);
		} else if ("editCategory".equals(op)) {
			editCategory(request, response);
		} else if ("delBook".equals(op)) {
			delBook(request, response);
		} else if ("editBookView".equals(op)) {
			editBookView(request, response);
		} else if ("editBook".equals(op)) {
			editBook(request, response);
		}
	}

	/**
	 * 删除购物项目
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void delOneItem(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String bookId = request.getParameter("bookId");
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
	
		cart.getItems().remove(bookId);
		
		// 重定向
		response.sendRedirect(request.getContextPath()+"/showCart.jsp");
		
	}

	/**
	 * 修改购物项的数量
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void changeNum(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String bookId = request.getParameter("bookId");
		String newNum = request.getParameter("num");
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		CartItem item = cart.getItems().get(bookId);
		item.setQuantity(Integer.parseInt(newNum));
		
		// 重定向
		response.sendRedirect(request.getContextPath()+"/showCart.jsp");
		
		
		
	}

	/**
	 * 购买书籍
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void buyBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String bookId = request.getParameter("bookId");

		Book b = s.findBookById(bookId);

		HttpSession session = request.getSession();

		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		cart.addBook(b);
		System.out.println("cart" + cart.getItems());
		request.setAttribute("msg",
				"书籍购买成功，<a href='" + request.getContextPath() + "'>请继续购物！</a>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);

	}

	/**
	 * 展示图书的详细信息
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void showBookDetails(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");

		Book b = s.findBookById(bookId);

		request.setAttribute("b", b);

		request.getRequestDispatcher("/showBookDetails.jsp").forward(request,
				response);

	}

	/**
	 * 按照分类查询图书
	 * 
	 * @param request
	 * @param response
	 *  pagenum 当前页码
	 *  categoryId 分类的id
	 * @throws IOException
	 * @throws ServletException
	 * 
	 *             为什么要有这2个参数？ 一共要有分页 所以需要 pagenum 另一个要显示某一个固定分类中的图书categoryId
	 *             因为 我们在jsp 取循环数据 是 page.records 是从page 取出来的！ 所以我们的返回值类型为page对象
	 *             因为该方法之前不存在 ，所以我们需要create method
	 */
	private void showCategoryBooks(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String pagenum = request.getParameter("pagenum");
		String categoryId = request.getParameter("categoryId");

		List<Category> cs = s.findAllCategory();

		Page page = s.findAllBookPageRecords(pagenum, categoryId);

		page.setUrl("servlet/ControlServlet?op=showCategoryBooks&categoryId="
				+ categoryId);

		request.setAttribute("page", page);
		request.setAttribute("cs", cs);

		request.getRequestDispatcher("/showAllBooks.jsp").forward(request,
				response);
	}

	/**
	 * 展示一个首页
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void showIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String pagenum = request.getParameter("pagenum");

		Page page = s.findAllBook(pagenum);

		page.setUrl("servlet/ControlServlet?op=showIndex");

		List<Category> cs = s.findAllCategory();

		request.setAttribute("page", page);
		request.setAttribute("cs", cs);

		request.getRequestDispatcher("/showAllBooks.jsp").forward(request,
				response);

	}

	/**
	 * 用户注销：退出登录、跳转到index.jsp
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * ☆ ★编辑图书：更新内容
	 * 
	 * @param request
	 * @param response
	 */
	private void editBook(HttpServletRequest request,
			HttpServletResponse response) {

		String bookId = request.getParameter("bookId");

		try {
			// 表示上传的表单是不是一个普通的表单
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (!isMultipart) {
				// 表示目前是一个普通的表单
				request.setAttribute("msg", "亲，您的表单填写有误，请检查！");
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
				// 表示判断语句结束
				return;
			}
			// 实例化 磁盘文件项工厂对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 实例化Servlet文件上传对象
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 拿到集合 - items
			List<FileItem> items = upload.parseRequest(request);
			// 这个 item对象 包含 前台传递过来的所有数据，包含图片的路径path和图片名称photoName
			for (FileItem item : items) {

				/*
				 * 如果isFormField方法结果是true 则代表是一个普通的表单字段
				 */
				if (item.isFormField()) {
					// 获取字段名称
					String fieldName = item.getFieldName();
					// 接收一下编码
					// item.getString();
					String fieldValue = item.getString(request
							.getCharacterEncoding());

					// 进行封装！！！ 通过 BeanUtils
					BeanUtils.setProperty(book, fieldName, fieldValue);
					book.setId(bookId);
				} else {
					/*
					 * 如果isFormField方法结果是false 则代表是一个上传的表单字段
					 */
					// 文件(图片)上传
					// 获取图片名称 比方说”：“神雕侠侣.jpg” 想把它换掉 ，因为 怕文件名称重复 会导致文件的覆盖
					String fieldName = item.getName();
					// 思考： 这个文件名称 是不是空的？
					if (fieldName != null && !fieldName.trim().equals("")) {
						// 文件名称不为空， 可以改一个名字 ： 唯一的文件名称
						// fieldName = UUID.randomUUID().toString() + "." +
						// FilenameUtils.getExtension(fieldName);
						// 存储的路径
						// TODO images的真实路径地址？
						// ServletContext servletContext = getServletContext();
						// servletContext.get
						String storeDirectory = getServletContext()
								.getRealPath("/images/");
						// 路径
						String path = SetPhotoPath.makeDir(storeDirectory,
								fieldName);

						// String path = "";//如果不需要设置多级目录（打散） 可以放开此句话
						book.setPath(path);
						book.setPhotoName(fieldName);

						// 上传
						item.write(new File(storeDirectory + path + "/"
								+ fieldName));

					}
				}
			}

			System.out.println("book:" + book);

			s.editBook(book);
			request.setAttribute("msg", "修改图书成功！");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 编辑图书： 回显数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void editBookView(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String bookId = request.getParameter("bookId");

		Book b = s.findBookById(bookId);

		List<Category> cs = s.findAllCategory();

		request.setAttribute("cs", cs);

		request.setAttribute("b", b);

		request.getRequestDispatcher("/editBook.jsp")
				.forward(request, response);

	}

	/**
	 * 删除图书
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void delBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		if (bookId != null && !"".equals(bookId)) {
			s.delBook(bookId);
			request.setAttribute("msg", "删除图书分类成功！");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		System.out.println("是不是空");
		response.sendRedirect(request.getContextPath() + "/error.jsp");

	}

	/**
	 * 编辑分类：更新内容
	 * 
	 * @param request
	 * @param response
	 */
	private void editCategory(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			Category category = new Category();

			BeanUtils.populate(category, request.getParameterMap());

			System.out.println("id" + category.getId());

			s.editCategory(category);

			request.setAttribute("msg", "修改分类成功！");

			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 编辑分类： 回显数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void editCategoryView(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String categoryId = request.getParameter("categoryId");

		Category c = s.findCategoryById(categoryId);

		request.setAttribute("c", c);

		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}

	/**
	 * 删除分类
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void delCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String categoryId = request.getParameter("categoryId");
		if (categoryId != null && !"".equals(categoryId)) {
			s.delCategory(categoryId);
			request.setAttribute("msg", "删除图书分类成功！");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
		System.out.println("是不是空");
		response.sendRedirect(request.getContextPath() + "/error.jsp");
	}

	/**
	 * 分页查询图书
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void showBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1. 从前台接受“当前页码”的参数
		String pagenum = request.getParameter("pagenum");

		List<Category> cs = s.findAllCategory();

		request.setAttribute("cs", cs);
		// 2.直接传递给service层
		Page page = s.findAllBook(pagenum);

		page.setUrl("servlet/ControlServlet?op=showBook");

		// 3.将返回的对象封装给page
		request.setAttribute("page", page);
		// 4.跳转显示的页码
		request.getRequestDispatcher("/bookList.jsp")
				.forward(request, response);
	}

	/**
	 * ★ 添加图书 难点： 上传图片
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private void addBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			// 表示上传的表单是不是一个普通的表单
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (!isMultipart) {
				// 表示目前是一个普通的表单
				request.setAttribute("msg", "亲，您的表单填写有误，请检查！");
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
				// 表示判断语句结束
				return;
			}
			// 实例化 磁盘文件项工厂对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 实例化Servlet文件上传对象
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 拿到集合 - items
			List<FileItem> items = upload.parseRequest(request);
			// 这个 item对象 包含 前台传递过来的所有数据，包含图片的路径path和图片名称photoName
			for (FileItem item : items) {

				/*
				 * 如果isFormField方法结果是true 则代表是一个普通的表单字段
				 */
				if (item.isFormField()) {
					// 获取字段名称
					String fieldName = item.getFieldName();
					// 接收一下编码
					// item.getString();
					String fieldValue = item.getString(request
							.getCharacterEncoding());
					// 进行封装！！！ 通过 BeanUtils
					BeanUtils.setProperty(book, fieldName, fieldValue);
				} else {
					/*
					 * 如果isFormField方法结果是false 则代表是一个上传的表单字段
					 */
					// 文件(图片)上传
					// 获取图片名称 比方说”：“神雕侠侣.jpg” 想把它换掉 ，因为 怕文件名称重复 会导致文件的覆盖
					String fieldName = item.getName();
					// 思考： 这个文件名称 是不是空的？
					if (fieldName != null && !fieldName.trim().equals("")) {
						// 文件名称不为空， 可以改一个名字 ： 唯一的文件名称
						fieldName = UUID.randomUUID().toString() + "."
								+ FilenameUtils.getExtension(fieldName);
						// 存储的路径
						// images的真实路径地址？
						// 电脑里的服务器，也就是Tomcat里的webapps中的项目名称里...（图片不跟随程序项目走）
						String storeDirectory = getServletContext()
								.getRealPath("/images/");
						// 路径
						String path = SetPhotoPath.makeDir(storeDirectory,
								fieldName);

						// String path = "";//如果不需要设置多级目录（打散） 可以放开此句话
						book.setPath(path);
						book.setPhotoName(fieldName);

						// 上传
						item.write(new File(storeDirectory + path + "/"
								+ fieldName));

					}
				}
			}
			s.addBook(book);
			request.setAttribute("msg", "添加图书成功");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 带着分类名称去跳转到添加图书界面
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void addBookView(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> cs = s.findAllCategory();
		request.setAttribute("cs", cs);
		request.getRequestDispatcher("/addBook.jsp").forward(request, response);

	}

	/*
	 * 只有request.setAttribute("",) 可以在jsp中直接取出
	 */
	/**
	 * 用户登录
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void userLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");

		User u = s.userLogin(username, password, type);
		// 如果u 不为空 表示有东西 ，则可以登录
		if (u != null) {
			// session 表示会话 cookie
			HttpSession session = request.getSession();

			// 用户信息存放session域中
			session.setAttribute("u", u);
			// 判断角色是否是管理员
			if ("管理员".equals(u.getType())) {
				// 重定向 到 main.jsp
				response.sendRedirect(request.getContextPath() + "/main.jsp");
				return;
			} else {
				// 重定向 到 index.jsp
				response.sendRedirect(request.getContextPath() + "/index.jsp");
				return;
			}

		} else {
			request.setAttribute("msg", "登录有误！");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		}

	}

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void userRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		User user;
		try {
			user = new User();
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		System.out.println("username:" + user.getUsername());

		s.userRegister(user);

		request.setAttribute("msg", "用户注册成功！");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * 查询所有分类
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void findAllCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Category> cs = s.findAllCategory();
		request.setAttribute("cs", cs);
		request.getRequestDispatcher("/categoryList.jsp").forward(request,
				response);

	}

	/**
	 * 添加分类
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void addCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 1. 创建一个分类的对象
		Category category = new Category();
		// 2. 接收了前台的name属性 和description 属性
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		// 3. 通过对象 封装到 description

		category.setName(name);
		category.setDescription(description);
		System.out.println("分类" + category);
		// 分类 哈希值

		System.out.println("分类名称：" + category.getName());
		s.addCategory(category);
		// 2018-11-20 写入
		// 添加一个成功的提示信息 ，临时性将“添加分类成功” 存放到msg
		// 设置一个标记 为msg （自个取得名字） 讲我想要的提示信息 放在后面的参数中
		request.setAttribute("msg", "添加分类成功！");
		// 转发到message的jsp页面，通过msg 讲存入进的“添加分类成功”信息取出来
		request.getRequestDispatcher("/message.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
