package cn.javabs.school.dao.impl;

import cn.javabs.school.dao.AdminDao;
import cn.javabs.school.entity.Admin;
import cn.javabs.school.exception.AdminLoginException;
import cn.javabs.util.DbcpUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * 管理员的数据访问层的实现类
 */
public class AdminDaoImpl implements AdminDao {
    QueryRunner qr = new QueryRunner(DbcpUtil.getDataSource());
    @Override
    public Admin loginAdmin(String usercode, String password) {

        try {
            String sql = "select * from admin where usercode = ? and password = ?";
            return qr.query(sql,new BeanHandler<Admin>(Admin.class), usercode,password);
        } catch (SQLException e) {
          throw  new AdminLoginException(e);
        }

    }
}
