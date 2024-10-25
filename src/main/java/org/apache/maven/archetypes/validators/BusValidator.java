package org.apache.maven.archetypes.validators;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BusValidator {

    /** Валидным является номер маршрута с 1 по 100 **/
    public static Integer busRouteValidate(Integer route) throws InputMismatchException {
        if (route >= 1 && route <= 100)
            return route;
        else {
            System.out.println("The entered value does not satisfy the following conditions:\n"
                    + "Route number should be Integer value (from 1 to 100)\n"
                    + "------------------------------------------------------------\n"
                    + "Enter the correct Route number manually:");
            return busRouteValidate(new Scanner(System.in).nextInt());
        }
    }

    /** Валидным является значение, состоящее из букв, длиной от 1 до 15 символов **/
    public static String busModelValidate(String model) {
        boolean flag = model.trim().length() >= 1 && model.trim().length() <= 15;
        for (int i = 0; i < model.trim().length(); i++) {
            if (!Character.isLetter(model.charAt(i))) {
                flag = false;
                break;
            }
        }
        if (flag)
            return model.trim();
        else {
            System.out.println("The entered value does not satisfy the following conditions:\n"
                    + "Model should contain only letters and it's length should be from 1 to 15\n"
                    + "------------------------------------------------------------\n"
                    + "Enter the correct Model manually:");
            return busModelValidate(new Scanner(System.in).next());
        }
    }

    /** Валидным является пробег от 1 по 1_000_000 **/
    public static Integer busMileageValidate(Integer mileage) throws InputMismatchException {
        if (mileage >= 1 && mileage <= 1_000_000)
            return mileage;
        else {
            System.out.println("The entered value does not satisfy the following conditions:\n"
                    + "Mileage should be Integer value (from 1 to 1_000_000)\n"
                    + "------------------------------------------------------------\n"
                    + "Enter the correct Mileage manually:");
            return busMileageValidate(new Scanner(System.in).nextInt());
        }
    }
}