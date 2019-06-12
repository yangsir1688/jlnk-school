package cn.javabs.bookstore.dao;

import cn.javabs.bookstore.entity.User;

public interface UserDao {

	void save(User user);

	User login(String username, String password, String type);

}
