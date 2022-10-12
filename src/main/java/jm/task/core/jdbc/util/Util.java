package jm.task.core.jdbc.util;

import java.sql.*;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=UTF-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    private static final String HIBERNATE_DIALECT = "org.hibernate.dialect.MySQLDialect";
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER_CLASS);
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
    public static SessionFactory getSession() {
        Configuration config = new Configuration()
                .setProperty("hibernate.connection.url", URL)
                .setProperty("hibernate.connection.driver_class", DRIVER_CLASS)
                .setProperty("hibernate.connection.username", USERNAME)
                .setProperty("hibernate.connection.password", PASSWORD)
                .setProperty("hibernate.dialect", HIBERNATE_DIALECT)
                .addAnnotatedClass(User.class);
        return config.buildSessionFactory();
    }
}
