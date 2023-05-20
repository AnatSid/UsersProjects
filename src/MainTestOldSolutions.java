import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTestOldSolutions {

    private static Scanner scanner;
    private static UsersBook usersBook;

    public static void main(String[] args) {

        usersBook = new UsersBook();
        scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Чтобы получить данные всех пользователей, введите команду => 'getAllUsers'");
            System.out.println("Чтобы получить данные пользователя по ID , введите команду => 'getUserForId'");
            System.out.println("Чтобы добавить нового пользователя, введи команду => add");

            String name = takeNameOrSurname("Введите ваше имя:");
            String surName = takeNameOrSurname("Введите вашу фамилию:");
            int age = takeAge("Введите ваш возраст:");

            User user = new User(name, surName, age);
            usersBook.addUser(user);

            System.out.println("Новый пользователь создан. Ваш id: " + user.getId());
            System.out.println("_________________________");
        }

    }

    private static boolean checkCorrectInputNameAndSurname(String nameOrSurname){
        Pattern pt = Pattern.compile("^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$");
        Matcher mt = pt.matcher(nameOrSurname);
        if(mt.matches()){
            return true;
        } else {
            return false;
        }
    }

    private static String takeNameOrSurname(String message){
        while (true){
            System.out.println(message);
            String inputName = scanner.nextLine();
            if(inputName.equals("getAllUsers")) {
                usersBook.getAllUsers();
            }
            if(inputName.equals("getUserForId")){
                System.out.println("Введите id пользователя: ");
                String inputId = scanner.nextLine();
                if(checkInputOnlyNumbersTrue(inputId)) {
                    int userId = Integer.parseInt(inputId);
                  //  usersBook.printUserForId(userId);
                }else {
                    System.out.println("Id должен содержать только цифры");
                }
            }
            if (checkCorrectInputNameAndSurname(inputName)) {
                    return inputName;
                }else {
                    System.out.println("Неверный ввод. Введите ваше имя/фамилию используя только буквы. Первая буква" +
                            " должна быть заглавной!");
                }
            }
        }

    private static int takeAge (String message) {
        while (true) {
            System.out.println(message);
            String inputAge = scanner.nextLine();

            if(checkInputOnlyNumbersTrue(inputAge)){
                int age = Integer.parseInt(inputAge);
                if (age > 0 && age < 101) {
                    return age;
                }else {
                    System.out.println("Неверно указан возраст. Введите целое число от 6 до 100 лет");
                }
            }
        }
    }


    private static boolean checkInputOnlyNumbersTrue(String inputAge){
        boolean isOnlyDigits = true;
        for(int i = 0; i < inputAge.length() && isOnlyDigits; i++) {
            if(!Character.isDigit(inputAge.charAt(i))) {
                isOnlyDigits = false;
            }
        }
        return isOnlyDigits;
    }


}