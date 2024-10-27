package org.apache.maven.archetypes.fillingAnArray;


import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.classes.Bus;
import org.apache.maven.archetypes.classes.Student;
import org.apache.maven.archetypes.classes.User;
import org.apache.maven.archetypes.fillingAnArray.DataArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArrayFilling {
    // создаёт лист объектов. принимает число (количество создаваемых объектов)
    public  static void createList(List<? super AbstractModel> list, int arraySize, Integer objType){

        for (int i = 0; i < arraySize; i++) {
            if (objType.equals(2)) {
                list.add(getStudent());
            } if (objType.equals(1)){
                list.add(getBus());
            }if (objType.equals(3)){
                list.add(getUser());
            }
        }

    }

    // создаёт рандомный экземпляр автобуса
    private static Bus getBus(){
        int ingexRouteBusArray = (int) (Math.random()*10); // рандом от 0 до 10
        int ingexModelBusArray = (int) (Math.random()*5); // рандом от 0 до 5
        int randomMileageBus = (int) (Math.random()*999999+1);   // рандом от 0 до 100

        Bus bus = Bus.newBusBuilder().
                setRoute(DataArray.routeBusArray[ingexRouteBusArray])   // данные из массива  DataArray  по индексу
                .setModel(DataArray.modelBusArray[ingexModelBusArray])  // данные из  массива DataArray  по индексу
                .setMileage(randomMileageBus)
                .build();
        return  bus;
    }
    private static Student  getStudent(){
        int randomGroupNumber = (int) ((Math.random()*9)+1);
        double randomAvgGrade = (Math.round(((Math.random()*3)+2) * 10));
        randomAvgGrade = randomAvgGrade/10;                                // рандомный средний бал  от 2,0 до 5,0

        int randomGradeBookNumber = (int) ((Math.random()*900)+100);

        Student student = Student.newStudentBuilder()
                .setGroupNumber(randomGroupNumber)
                .setAvgGrade(randomAvgGrade)
                .setGradeBookNumber(randomGradeBookNumber)
                .build();
        return student;
    }
    private static User getUser(){
        int indexNameUserArray = (int) (Math.random()*DataArray.nameUserArray.length);

        int ingexEmailUserArray = (int) (Math.random()* DataArray.emailUserArray.length);
        Random r = new Random();
        int passLength = r.nextInt(5)+5;
        char[] array = new char[passLength];
        int rand;
        for (int i = 0; i< passLength; i++) {
            rand = r.nextInt(79) + 47;
            array[i] = (char)rand;
        }
        String randomPassword = new  String(array);     // рандомный пароль из символов

        User user = User.newUserBuilder()
                .setEmail(DataArray.emailUserArray[ingexEmailUserArray])   // данные из  массива DataArray по индексу
                .setPassword(randomPassword)
                .setName(DataArray.nameUserArray[indexNameUserArray])     // данные из  массива DataArray по индексу
                .build();
      return   user;
    }
}
