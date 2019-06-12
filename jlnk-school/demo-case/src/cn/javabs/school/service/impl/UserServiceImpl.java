package cn.javabs.school.service.impl;

import cn.javabs.school.dao.UserDao;
import cn.javabs.school.dao.impl.UserDaoImpl;
import cn.javabs.school.entity.User;
import cn.javabs.school.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public User UserLogin(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int delUser(int id) {
        return userDao.delUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.getAllUsers();
    }

    @Override
    public User findUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User findUserByName(String username) {
        return userDao.getUserByName(username);
    }
}
