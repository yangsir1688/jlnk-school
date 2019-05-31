package cn.javabs.dao.impl;

import cn.javabs.utils.DbcpUtil;
import cn.javabs.dao.UserDao;
import cn.javabs.entity.User;
import cn.javabs.utils.DbcpUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * update: 增删改
 * query: 查
 * batch: 批处理  一次性解决大批量数据的传输  |  企业开发中用到的不多！
 */
public class UserDaoImpl implements UserDao {

    QueryRunner qr = new QueryRunner(DbcpUtil.getDataSource());

    @Override
    public int addUser(User u) {
        try {
            return qr.update("insert into user(username,password,sex) values(?,?,?)"   ,
                                           u.getUsername(),u.getPassword(),u.getSex() );
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}