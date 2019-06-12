package cn.javabs.bookstore.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 连接池、数据源  dbcp
 * @author Mryang
 */
public class DbcpUtils {

        public static DataSource dataSource;

        static{
            try {
                // 通过输入流获取  jdbc.properties 中的信息
                // .class 获取当前类的字节码
                // .getClassLoader 获取类加载器
                // .getResourceAsStream 获取“jdbc.properties”资源通过流
                String myFile = "dbcp.properties";
                InputStream in = DbcpUtils.class.getClassLoader().getResourceAsStream(myFile);
                // 实例化一个Properties
                Properties p = new Properties();
                //  调用p的加载方法
                p.load(in);

                // 基础数据源工厂 的  创建数据源
                dataSource = BasicDataSourceFactory.createDataSource(p);
            }  catch (Exception e) {
                throw new RuntimeException(e);// RuntimeException   运行时异常
            }
        }
        /**
         * 获取数据源
         * @return
         */
        public static DataSource getDataSource(){
            return dataSource;
        }
        /**
         * 获取连接
         * @return
         * @throws SQLException
         */
        public static Connection getConnection() throws SQLException {
            return dataSource.getConnection();
        }
}
