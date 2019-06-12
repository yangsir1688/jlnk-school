package cn.javabs.school.test;

import cn.javabs.school.entity.Admin;
import cn.javabs.school.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * 测试类: 用于测试数据库是否通畅
 * @author Mryang
 */
public class TestData {

    QueryRunner  qr =  new QueryRunner(DruidUtils.getDataSource());

    @Test
    public void fun(){
        try {
            System.out.println(2);
//            qr.update("insert into admin(id,name,pwd) values(?,?,?)",
//                    9,'c','c');
            Admin admin = new Admin();
            List<Admin> admins = qr.query("select * from admin", new BeanListHandler<Admin>(Admin.class));
            System.out.println(admins);
        } catch (SQLException e) {
            throw new RuntimeException("error:"+e);
        }
    }
}
