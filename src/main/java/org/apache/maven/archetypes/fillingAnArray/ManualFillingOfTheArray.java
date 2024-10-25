package org.apache.maven.archetypes.fillingAnArray;


import org.apache.maven.archetypes.classes.Bus;
import org.apache.maven.archetypes.classes.Student;
import org.apache.maven.archetypes.classes.User;

import java.util.List;


public class ManualFillingOfTheArray {
    // Принимает на вход лист студентов и поля для создания экземпляра, внутри заполняет лист.
          public static void addToListStudent(List<Student> list, Integer groupNumber, Double avgGrade, Integer gradeBookNumber){
              Student student = Student.newStudentBuilder()
                      .setGroupNumber(groupNumber)
                      .setAvgGrade(avgGrade)
                      .setGradeBookNumber(gradeBookNumber)
                      .build();
              list.add(student);
          }
    public static void addToListBus(List<Bus> list, Integer route, String model, Integer mileage){
       Bus bus = Bus.newBusBuilder()
               .setRoute(route)
               .setModel(model)
               .setMileage(mileage)
               .build();
        list.add(bus);
    }
    public static void addToListUser(List<User> list, String name, String email, String password){
        User user = User.newUserBuilder()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .build();
        list.add(user);
    }
 }






