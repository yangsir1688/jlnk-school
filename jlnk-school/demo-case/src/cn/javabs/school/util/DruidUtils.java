package cn.javabs.school.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 工具类全都使用static
 */
public class DruidUtils {

    private static DataSource dataSource = null;

    static  String myFile ="druid.properties";

    static {
        try {
            InputStream resourceAsStream = DruidUtils.class.getClassLoader().getResourceAsStream(myFile);
            Properties p = new Properties();
            p.load(resourceAsStream);
            // DruidDataSourceFactory核心类  德鲁意数据资源工厂 的  创建数据资源
            dataSource =  DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }


    public  static DataSource getDataSource(){
        return dataSource;
    }

    public  static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

}
