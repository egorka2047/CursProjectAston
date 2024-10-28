package org.apache.maven.archetypes.search;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.classes.Bus;
import org.apache.maven.archetypes.classes.Student;
import org.apache.maven.archetypes.classes.User;
import org.apache.maven.archetypes.fillingAnArray.ManualFillingOfTheArray;
import org.apache.maven.archetypes.validators.BusValidator;
import org.apache.maven.archetypes.validators.StudentValidator;
import org.apache.maven.archetypes.validators.UserValidator;

import java.util.List;
import java.util.Scanner;

public class InputSearchObj {

    public static AbstractModel input(List<? extends AbstractModel> list){

        String[] objTypeArr = list.getFirst().getClass().toString().split("\\.");
        String objType = objTypeArr[objTypeArr.length-1];
        System.out.printf("Введите параметры искомого объекта %s\n", objType);
        switch (objType){
            case "Bus":{
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
                return Bus.newBusBuilder().setMileage(mileage).setModel(model).setRoute(route).build();
            }
            case "Student":{
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
                return Student.newStudentBuilder().setGradeBookNumber(gradeBookNumber).setAvgGrade(avgGrade).setGroupNumber(groupNumber).build();
            }
            case "User":{
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
                return User.newUserBuilder().setPassword(password).setEmail(email).setName(name).build();
            }
            default: return Bus.newBusBuilder().build();
        }

    }
}
