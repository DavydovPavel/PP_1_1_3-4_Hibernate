package jm.task.core.jdbc.util;
import javax.swing.plaf.basic.BasicTreeUI;
import java.sql.*;
import java.sql.Statement;

import jm.task.core.jdbc.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionCreator;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=UTF-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static Connection getConnection () throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
}
