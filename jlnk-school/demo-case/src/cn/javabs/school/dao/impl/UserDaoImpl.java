package cn.javabs.school.dao.impl;

import cn.javabs.school.dao.UserDao;
import cn.javabs.school.entity.User;
import cn.javabs.school.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    QueryRunner qr =  new QueryRunner(DruidUtils.getDataSource());

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        try {
            return qr.update("insert into user(id,username,password,sex,birthday) values (?,?,?,?,?)",
                    user.getId(),user.getUsername(),user.getPassword(),user.getSex(),user.getBirthday());
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public int delUser(int id) {
        try {
            return qr.update("delete from  user where id = ?",id);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        try {
            return qr.update("update user set username = ? where id = ?",user.getUsername(),user.getId());
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        List<User> users = null;
        try {
            users = qr.query("select * from user", new BeanListHandler<User>(User.class));
            return users;
        } catch (SQLException e) {
           throw  new RuntimeException(e);
        }
    }

    /**
     * 根据用户id查询用户
     * @param id  参数是  用户的id
     * @return
     */
    @Override
    public User getUserById(int id) {
        try {
            User user = qr.query("select * from user where id = ?", new BeanHandler<User>(User.class),id);
            return user;
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    @Override
    public User getUserByName(String username) {
        try {
            User user = qr.query("select * from user where username = ?", new BeanHandler<User>(User.class),username);
            return user;
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public User login(String username, String password) {
        try {
            return qr.query("select * from user where username=? and  password =?", new BeanHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
