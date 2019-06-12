package cn.javabs.bookstore.dao.impl;

import java.sql.SQLException;

import cn.javabs.bookstore.dao.UserDao;
import cn.javabs.bookstore.utils.DbcpUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.javabs.bookstore.entity.User;

/**
 * 用户的dao实现类
 * @author Mryang
 *
 */
public class UserDaoImpl implements UserDao {

	QueryRunner qr = new QueryRunner(DbcpUtils.getDataSource());
	
	public void save(User user) {
		
		try {
			qr.update("insert into user(id,username,password,type,sex) values (?,?,?,?,?)",
					user.getId(),
					user.getUsername(),
					user.getPassword(),
					user.getType(),
					user.getSex()
					);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User login(String username, String password,String type) {
		try {
			//select * from user where username =xiaohong and password = 123
			//select * from user where username = 1 and password = 1 and type = '管理员';
			System.out.println("..."+username+password+type);
			User user =  qr.query("select * from user where username = ? and password = ? and type = ?", 
					new BeanHandler<User>(User.class),username,password,type);
			System.out.println("dao'user"+user);
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
