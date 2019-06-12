package cn.javabs.school.test;

import cn.javabs.school.entity.User;
import cn.javabs.school.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestData {

    QueryRunner qr =  new QueryRunner(DruidUtils.getDataSource());
    @Test
    public void  fun() throws SQLException {
        User user = new User();

        List<User> users = qr.query("select * from user", new BeanListHandler<User>(User.class));

        System.out.println(users);
    }

}
