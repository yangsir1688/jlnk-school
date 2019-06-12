package cn.javabs.bookstore.dao;

import java.util.List;

import cn.javabs.bookstore.entity.Category;

public interface CategoryDao {

	/**
	 * 添加分类
	 * @param category
	 */
	void save(Category category);

	/**
	 * 查询所有分类
	 * @return
	 */
	List<Category> getAllCategory();

	/**
	 * 根据id查询分类
	 * @param id
	 * @return
	 */
	Category getCategoryById(String id);

	/**
	 *  根据id移除分类
	 * @param categoryId
	 */
	void removeCategory(String c);

	/**
	 * 修改分类
	 * @param category
	 */
	void updateCategory(Category category);



}
