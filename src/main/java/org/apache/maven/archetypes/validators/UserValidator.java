package org.apache.maven.archetypes.validators;

import java.util.Scanner;
import java.util.Set;

public class UserValidator {

    /** Валидным является значение, состоящее из букв, длиной от 2 до 12 символов **/
    public static String userNameValidate(String name) {
        boolean flag = name.trim().length() >= 2 && name.trim().length() <= 12;
        for (int i = 0; i < name.trim().length(); i++) {
            if (!Character.isLetter(name.charAt(i))) {
                flag = false;
                break;
            }
        }
        if (flag)
            return name.trim();
        else {
            System.out.println("The entered value does not satisfy the following conditions:\n"
                    + "Name should contain only letters and it's length should be from 2 to 12\n"
                    + "------------------------------------------------------------\n"
                    + "Enter the correct Name manually:");
            return userNameValidate(new Scanner(System.in).next());
        }
    }

    /** Валидным явлется начение, удовлетворяющее слежующим требованиям:
     1. Длина имени пользователя - от  2 до 30 символов (допустимы буквы, цифры, точки
        (точки - за исключением начала и конца имени пользователя)).
     2. Имя пользователя и доменное имя разделены символом "@".
     3. Допустимы следующие доменные имена:
     gmail.com, yandex.ru, mail.ru, bk.ru, live.com, rambler.ru, outlook.com, yahoo.com **/
    public static String userEmailValidate(String email) {
        Set<String> domainSet = Set.of(
                "@gmail.com",
                "@yandex.ru",
                "@mail.ru",
                "@bk.ru",
                "@live.com",
                "@rambler.ru",
                "@outlook.com",
                "@yahoo.com"
        );
        String userName = email.trim().substring(0, email.trim().indexOf('@'));
        boolean flag = true;
        if (userName.startsWith(".") || userName.endsWith("."))
            flag = false;
        for (int i = 0; i < userName.length(); i++) {
            if (!(Character.isLetter(userName.charAt(i)) || Character.isDigit(userName.charAt(i)) || userName.charAt(i) == '.'))
                flag = false;
        }
        if (!domainSet.contains(email.trim().toLowerCase().substring(email.trim().indexOf("@"))))
            flag = false;
        if (userName.length() < 2 || userName.length() > 30)
            flag = false;
        for (int i = 0; i < email.trim().length(); i++) {
            if (email.trim().charAt(i) == ' ') {
                flag = false;
                break;
            }
        }
        if (flag)
            return email.trim();
        else {
            System.out.println("The entered value does not satisfy the following conditions:\n"
                    + "Email should end with "
                    + "@gmail.com, @yandex.ru, @mail.ru, @bk.ru, @live.com, @rambler.ru, @outlook.com, @yahoo.com\n"
                    + "The length of the user name in Email should be from 2 to 30 characters "
                    + "(only letters, digits and the dot symbol \n(the dot symbol isn't allowed at "
                    + "the beginning and end of user name in Email))\n"
                    + "------------------------------------------------------------\n"
                    + "Enter the correct Email manually:");
            return userEmailValidate(new Scanner(System.in).next());
        }
    }

    /** Валидным является значение, длиной от 5 до 10 символов **/
    public static String passwordValidate(String password) {
        if (password.trim().length() >= 5 && password.trim().length() <= 10)
            return password.trim();
        else {
            System.out.println("The entered value does not satisfy the following conditions:\n"
                    + "Password length should contain from 5 to 10 characters inclusive\n"
                    + "------------------------------------------------------------\n"
                    + "Enter the correct Password manually:");
            return passwordValidate(new Scanner(System.in).next());
        }
    }
}