package org.apache.maven.archetypes.userinterface.FillStrategy.ManualInput;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.fillingAnArray.ManualFillingOfTheArray;
import org.apache.maven.archetypes.userinterface.FillStrategy.UserInputInt;
import org.apache.maven.archetypes.validators.BusValidator;

import java.util.List;
import java.util.Scanner;

public class ManualBusInput {
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
                    Integer route;
                    String model;
                    Integer mileage;
                    while (true){
                        System.out.print("Введите номер маршрута автобуса:");
                        Scanner sc = new Scanner(System.in);
                        if (sc.hasNextInt()) {
                            route = BusValidator.busRouteValidate(sc.nextInt());
                            break;
                        }
                        else System.out.println("Введите целочисленное значение");
                    }

                    while (true){
                        System.out.print("Введите модель автобуса:");
                        Scanner sc = new Scanner(System.in);
                        if (sc.hasNext()) {
                            model = BusValidator.busModelValidate(sc.nextLine());
                            break;
                        }
                        else System.out.println("Введите непустую строку");
                    }

                    while (true){
                        System.out.print("Введите пробег автобуса автобуса:");
                        Scanner sc = new Scanner(System.in);
                        if (sc.hasNextInt()) {
                            mileage = BusValidator.busMileageValidate(sc.nextInt());
                            break;
                        }
                        else System.out.println("Введите целочисленное значение");
                    }
                    ManualFillingOfTheArray.addToListBus(list,route,model,mileage);
                    break;
                }
                case 2:
                    conditions = false;
                    break;

            }
        }
    }

}
