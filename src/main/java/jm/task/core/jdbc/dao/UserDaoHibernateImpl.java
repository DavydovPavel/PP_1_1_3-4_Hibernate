package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;

import jm.task.core.jdbc.util.Util;
import org.hibernate.*;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        Session session = Util.getSession().openSession();
        Transaction trans = session.beginTransaction();
        try {String mySql =
                "create table if not exists mysql.users (id bigint not null auto_increment,"
                        + "name varchar(25),lastName varchar(25) not null,"
                        + "age integer,"
                        + "primary key(id))";
            session.createNativeQuery(mySql).executeUpdate();
            trans.commit();
            session.close();
        } catch (HibernateException e) {
            e.getMessage();
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSession().openSession();
        Transaction trans = session.beginTransaction();
        try {
            session.createNativeQuery("drop table if exists mysql.users").executeUpdate();
            trans.commit();
            session.close();
        }catch (HibernateException e){
            System.out.println("Table is not exists");
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = Util.getSession().openSession();
        Transaction trans = session.beginTransaction();
        try {
            session.save(new User(name, lastName, age));
            trans.commit();
            System.out.println("User с именем " + name + " добавлен в базу данных");
            session.close();
        }catch (HibernateException e){
            e.getMessage();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSession().openSession();
        Transaction trans = session.beginTransaction();
        try {
            session.delete(session.get(User.class, id));
            trans.commit();
            session.close();
        }catch (HibernateException e) {
            e.getMessage();
        }
    }
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Session session = Util.getSession().openSession();
        Transaction trans = session.beginTransaction();
        try {
            users = session.createNativeQuery("select * from mysql.users").addEntity(User.class).list();
            trans.commit();
            session.close();
        }catch (HibernateException e) {
            e.getMessage();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSession().openSession();
        Transaction trans = session.beginTransaction();
        try {
            session.createNativeQuery("truncate table mysql.users").executeUpdate();
            trans.commit();
            session.close();
        }catch (HibernateException e){
            e.getMessage();
        }
    }
}
