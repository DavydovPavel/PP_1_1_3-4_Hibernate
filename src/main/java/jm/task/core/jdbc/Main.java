package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    private final static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Федор Михалыч","ДостоЕвский" , (byte) 126);
        userService.saveUser("Nikita","Djigurda" , (byte) 95);
        userService.saveUser("Yoko","OnooOOOOOOOOOOO" , (byte) 75);
        userService.saveUser("AziiiiiiiiiiiiizA","" , (byte) 11);

        for (User user: userService.getAllUsers()) {
            System.out.println(user.toString());
        }
        userService.removeUserById(1);
        System.out.println("------------");
        for (User user: userService.getAllUsers()) {
            System.out.println(user.toString());
        }
        userService.cleanUsersTable();
        System.out.println("------------");
        for (User user: userService.getAllUsers()) {
            System.out.println(user.toString());
        }
        userService.dropUsersTable();


    }
}
