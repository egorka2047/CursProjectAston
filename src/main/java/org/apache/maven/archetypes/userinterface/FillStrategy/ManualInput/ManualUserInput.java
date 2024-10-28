package org.apache.maven.archetypes.userinterface.FillStrategy.ManualInput;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.fillingAnArray.ManualFillingOfTheArray;
import org.apache.maven.archetypes.userinterface.FillStrategy.UserInputInt;
import org.apache.maven.archetypes.validators.BusValidator;
import org.apache.maven.archetypes.validators.StudentValidator;
import org.apache.maven.archetypes.validators.UserValidator;

import java.util.List;
import java.util.Scanner;

public class ManualUserInput {

    public static void input (List<? super AbstractModel> list){
        boolean conditions = true;
        while (conditions){
            Integer command;
            while (true){
                System.out.println("""
                        Хотите добавить новый элемент ?
                        1) Да
                        2) Нет
                        """);
                command = UserInputInt.validUserInput();
                if (List.of(1,2).contains(command)) break;
                else System.out.println("Указанного номера команды не существует, пожалуйста, повторите ввод");
            }
            switch (command){
                case 1:{
                    String name;
                    String email;
                    String password;
                    while (true){
                        System.out.print("Введите имя пользователя");
                        Scanner sc = new Scanner(System.in);
                        if (sc.hasNext()) {
                            name = UserValidator.userNameValidate(sc.nextLine());
                            break;
                        }
                        else System.out.println("Введите непустую строку");
                    }

                    while (true){
                        System.out.print("Введите адрес электронной почты пользователя:");
                        Scanner sc = new Scanner(System.in);
                        if (sc.hasNext()) {
                            email = UserValidator.userEmailValidate(sc.nextLine());
                            break;
                        }
                        else System.out.println("Ведите непустую строку");
                    }

                    while (true){
                        System.out.print("Введите пароль пользователя:");
                        Scanner sc = new Scanner(System.in);
                        if (sc.hasNext()) {
                            password = UserValidator.passwordValidate(sc.nextLine());
                            break;
                        }
                        else System.out.println("Ведите непустую строку");
                    }
                    ManualFillingOfTheArray.addToListUser(list,name,email,password);
                    break;
                }
                case 2:
                    conditions = false;
                    break;

            }
        }
    }
}
