import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        UsersBook usersBook = new UsersBook();
        User user1 = new User("dsfsd","fdsfsf",25);
        User user2 = new User("dsfsd","fdsfsf",4);

        usersBook.addUser(user1);
        usersBook.addUser(user2);

        ArrayList<User> users = new ArrayList<>();
        users.addAll(usersBook.getAllUsers());

        for (User user:users) {
            System.out.println(user);
        }

        System.out.println(usersBook.getUserForId(1));
        System.out.println(usersBook.getUserForId(4));



    }


}

