package org.apache.maven.archetypes.userinterface.FillStrategy;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.classes.Bus;
import org.apache.maven.archetypes.classes.Student;
import org.apache.maven.archetypes.classes.User;
import org.apache.maven.archetypes.fillingAnArray.RandomArrayFilling;

import java.util.List;
import java.util.Scanner;

public class RandomFill extends FillStrategy{

    public RandomFill() {
        super("Случайная генерация данных", 3);
    }

    @Override
    public void runCommand(List<? super AbstractModel> list) {
        Integer objType;
        while(true){
            System.out.println("Список каких объектов хотите создать ?\n" +
                    "1) Bus\n" +
                    "2) Student\n" +
                    "3) User\n");
            objType = UserInputInt.validUserInput();
            if (List.of(1,2,3).contains(objType)) break;
            else System.out.println("Указанного номера объекта не существует, пожалуйста, повторите ввод");
        }
        Integer numObj;
        while(true){
            System.out.println("Введите количество объектов, которое нужно создать: ");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()){
                numObj = sc.nextInt();
                break;
            }
            else System.out.println("Введите целочисленное значение");
        }
        RandomArrayFilling.createList(list,numObj,objType);
        System.out.println(list);

    }
}
