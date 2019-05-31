package cn.javabs.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbcpUtil {

    public static DataSource dataSource;

    static {
        try {
            InputStream inputStream = DbcpUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
             throw  new   RuntimeException(e);
        }
    }
    public static  DataSource getDataSource(){
        return  dataSource;
    }
    public static Connection getcConnection() throws SQLException {
        return  dataSource.getConnection();
    }
}
