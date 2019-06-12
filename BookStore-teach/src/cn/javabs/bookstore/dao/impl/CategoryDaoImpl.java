package cn.javabs.bookstore.dao.impl;

import java.sql.SQLException;
import java.util.List;

import cn.javabs.bookstore.utils.DbcpUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.javabs.bookstore.dao.CategoryDao;
import cn.javabs.bookstore.entity.Category;

/**
 *
 * @author Mryang
 * 原因是  实现类必须要覆写 接口中全部的方法
 */
public class CategoryDaoImpl implements CategoryDao {
	/**
	 * QueryRunner 是 Apache 组织的一个工具
	 * 是操作数据库的一个组件， 对jdbc进行了简单的封装，不影响原有的性能、而且极大地简化了编码
	 * 
	 * update 方法只适合于  数据库的  插入语句、删除语句、修改语句
	 * 
	 * query  方法适用于查询语句
	 *  ResultSetHandler： 结果集处理器  是一个接口
	 *  		|----  实现类
	 *  				|---- beanHandler :  返回的是封装一行数据的结果集对象
	 *  				|---- beanListHandler :  返回的是封装多行数据的结果集对象
	 *  				|---- ScalarHandler :  返回的是封装某行或者某列数据的结果集对象
	 * 
	 */
	QueryRunner qr  = new QueryRunner(DbcpUtils.getDataSource());

	/**
	 * 添加分类
	 */
	public void save(Category category) {
		try {
			qr.update("insert into category(id,name,description) values (?,?,?) ", 
					category.getId(),
					category.getName(),
					category.getDescription());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 查询所有分类
	 */
	public List<Category> getAllCategory() {
		try {
			return qr.query("select * from category", new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);// 转换成运行时异常  抛出去
		}
	}

	/**
	 * 根据id查询分类
	 */
	public Category getCategoryById(String id) {
	
		try {
			 Category c = qr.query("select * from category where id = ?",new BeanHandler<Category>(Category.class),id);
			 return c;
		} catch (SQLException e) {
			throw new RuntimeException(e);// 转换成运行时异常  抛出去
		}
	}

	/**
	 * 根据id删除分类
	 */
	public void removeCategory(String categoryId) {
		try {
			System.out.println("dao实现的id: " +categoryId);
			
			qr.update("delete from category where id = ? ",categoryId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 修改分类
	 */
	public void updateCategory(Category category) {
		try {
			qr.update("update category set name = ?,description= ? where id = ? ", 
					category.getName(),
					category.getDescription(),
					category.getId());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}














