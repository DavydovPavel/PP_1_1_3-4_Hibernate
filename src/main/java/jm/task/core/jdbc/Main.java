package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    private final static UserService myUser = new UserServiceImpl();
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        myUser.dropUsersTable();
        myUser.createUsersTable();
        myUser.saveUser("Федор Михалыч","ДостоЕвский" , (byte) 126);
        myUser.saveUser("Nikita","Djigurda" , (byte) 95);
        myUser.saveUser("Yoko","OnooOOOOOOOOOOO" , (byte) 75);
        myUser.saveUser("AziiiiiiiiiiiiizA","" , (byte) 11);

        for (User user: myUser.getAllUsers()) {
            System.out.println(user.toString());
        }
        myUser.removeUserById(1);
        System.out.println("------------");
        for (User user: myUser.getAllUsers()) {
            System.out.println(user.toString());
        }
        myUser.cleanUsersTable();
        System.out.println("------------");
        for (User user: myUser.getAllUsers()) {
            System.out.println(user.toString());
        }
        myUser.dropUsersTable();


    }
}
