package cn.javabs.school.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbcpUtils {
    private  static DataSource dataSource;
    static  String  myFile = "dbcp.properties";

    static {
        try {
            InputStream resourceAsStream = DruidUtils.class.getClassLoader().getResourceAsStream(myFile);
            Properties p = new Properties();
            p.load(resourceAsStream);
            // 调用的核心类是BasicDataSourceFactory
            dataSource = BasicDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    public static DataSource getDataSource(){
        return  dataSource;
    }

    public static Connection getConnection(){
        try {
            return  dataSource.getConnection();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
