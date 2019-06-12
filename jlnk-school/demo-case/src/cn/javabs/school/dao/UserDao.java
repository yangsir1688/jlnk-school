package cn.javabs.school.dao;

import cn.javabs.school.entity.User;

import java.util.List;

public interface UserDao {

    int addUser(User user);

    int delUser(int id);

    int updateUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    User getUserByName(String username);

    User login(String username, String password);
}
