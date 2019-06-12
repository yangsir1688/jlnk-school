package cn.javabs.bookstore.commons;

import cn.javabs.bookstore.service.BusinessService;
import cn.javabs.bookstore.service.impl.BusinessServiceImpl;
import cn.javabs.bookstore.entity.Category;

/**
 * 为了获取分类名称，仅此而已！！
 * @author Mryang
 *	通过分类的id获取  工具类
 */
public class MyFunction {
	/*
	 * 使用service 是为了 想 通过service  去找dao 执行查询id的方法  返回给我一个分类对象
	 * 该对象中包含分类的所有信息（id、name、description）
	 * 拿到了name
	 */
	public static BusinessService service = new BusinessServiceImpl();
		
		/**
		 * 展示分类名称的方法
		 * @param categoryId
		 * @return
		 */
		public static String showCategoryName(String categoryId){
	
			Category category = service.findCategoryById(categoryId);
	
				if(category != null){
					return category.getName();
				}
				return null;
			}
		
	}
