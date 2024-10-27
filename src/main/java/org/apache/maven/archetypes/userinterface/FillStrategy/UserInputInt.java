package org.apache.maven.archetypes.userinterface.FillStrategy;

import java.util.Scanner;

public class UserInputInt {
    public static Integer validUserInput(){
        Integer userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер нужной команды: ");
        while (true){
            if (scanner.hasNextInt()){
                userInput = scanner.nextInt();
                return userInput;
            }
            else{
                scanner.nextLine();
                System.out.print("введите числовое значение команды: ");
            }
        }
    }
}
