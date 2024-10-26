package org.apache.maven.archetypes.userinterface.FillStrategy.ManualInput;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.fillingAnArray.ManualFillingOfTheArray;
import org.apache.maven.archetypes.userinterface.FillStrategy.UserInputInt;
import org.apache.maven.archetypes.validators.BusValidator;
import org.apache.maven.archetypes.validators.StudentValidator;

import java.util.List;
import java.util.Scanner;

public class ManualStudentInput {
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
                    Integer groupNumber;
                    Double avgGrade;
                    Integer gradeBookNumber;
                    while (true){
                        System.out.print("Введите номер группы студента:");
                        Scanner sc = new Scanner(System.in);
                        if (sc.hasNextInt()) {
                            groupNumber = StudentValidator.studentGroupNumberValidate(sc.nextInt());
                            break;
                        }
                        else System.out.println("Введите целочисленное значение");
                    }

                    while (true){
                        System.out.print("Введите среднюю оценку студента:");
                        Scanner sc = new Scanner(System.in);
                        if (sc.hasNextDouble()) {
                            avgGrade = StudentValidator.studentAvgGradeValidate(sc.nextDouble());
                            break;
                        }
                        else System.out.println("Введите действительное число через запятую");
                    }

                    while (true){
                        System.out.print("Введите номер зачетной книжки студента:");
                        Scanner sc = new Scanner(System.in);
                        if (sc.hasNextInt()) {
                            gradeBookNumber = BusValidator.busMileageValidate(sc.nextInt());
                            break;
                        }
                        else System.out.println("Введите целочисленное значение");
                    }
                    ManualFillingOfTheArray.addToListStudent(list,groupNumber,avgGrade,gradeBookNumber);
                }
                case 2:
                    conditions = false;
                    break;

            }
        }
    }
}
