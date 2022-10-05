package jm.task.core.jdbc.util;
import javax.swing.plaf.basic.BasicTreeUI;
import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=UTF-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

    public static Connection getConnection () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (connection == null || !connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Соединение с БД установлено");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getStackTrace();
            System.out.println("Ошибка загрузки драйвера");
        }
    return connection;
    }

}
