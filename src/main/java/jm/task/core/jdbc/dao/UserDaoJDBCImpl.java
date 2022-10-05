package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection = Util.getConnection();
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            String mySql =
                      "create table if not exists mysql.users (id bigint not null auto_increment,"
                    + "name varchar(25),lastName varchar(25) not null,"
                    + "age integer,"
                    + "primary key(id))";
            statement.executeUpdate(mySql);
        }catch (SQLException e){
            e.getMessage();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("drop table mysql.users");
        }catch (SQLException e) {
            System.out.println("Table is not exists");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try(PreparedStatement statement = connection
                .prepareStatement("insert into mysql.users(name,lastName,age) values (?,?,?)")) {
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setByte(3,age);
            statement.executeUpdate();
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try(PreparedStatement statement = connection
                .prepareStatement("delete from mysql.users where id = ?" )) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try(Statement statement = connection.createStatement()){
            ResultSet res = statement.executeQuery("select * from mysql.users");
            while (res.next()){
                User user = new User();
                user.setId(res.getLong("id"));
                user.setName(res.getString("name"));
                user.setLastName(res.getString("lastName"));
                user.setAge(res.getByte("age"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("delete from mysql.users");
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
