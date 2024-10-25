package org.apache.maven.archetypes.fillingAnArray;


import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.classes.Bus;
import org.apache.maven.archetypes.classes.Student;
import org.apache.maven.archetypes.classes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArrayFilling {
    // создаёт лист объектов. принимает число (количество создаваемых объектов)
    public  static List<AbstractModel> createList(AbstractModel abstractModel, int arraySize){
        List<AbstractModel> list = new ArrayList<>();

        for (int i = 0; i < arraySize; i++) {
            if (abstractModel.getClass() == Student.class) {
                list.add(getStudent());
            } if (abstractModel.getClass() == Bus.class){
                list.add(getBus());
            }if (abstractModel.getClass() == User.class){
                list.add(getUser());
            }
        }

return list;
    }

    // создаёт рандомный экземпляр автобуса
    private static Bus getBus(){
        int ingexRouteBusArray = (int) (Math.random()*10); // рандом от 0 до 10
        int ingexModelBusArray = (int) (Math.random()*5); // рандом от 0 до 5
        int randomMileageBus = (int) (Math.random()*100);   // рандом от 0 до 100

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
        char[] array = new char[7];
        int rand;
        Random r = new Random();
        for (int i = 0; i< 7; i++) {
            rand = r.nextInt(127) + 1;
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
