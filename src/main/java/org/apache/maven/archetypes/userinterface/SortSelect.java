package org.apache.maven.archetypes.userinterface;


import org.apache.maven.archetypes.CastomObjectArray;
import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.classes.Bus;
import org.apache.maven.archetypes.classes.Student;
import org.apache.maven.archetypes.classes.User;
import org.apache.maven.archetypes.sort.NaturalSort;
import org.apache.maven.archetypes.sort.strategySort.BusSortWithStrategy;
import org.apache.maven.archetypes.sort.strategySort.StudentSortWithStrategy;
import org.apache.maven.archetypes.sort.strategySort.UserSortWithStrategy;
import org.apache.maven.archetypes.userinterface.FillStrategy.UserInputInt;

import java.util.ArrayList;
import java.util.List;

public class SortSelect {

    public static void startSelect(List<AbstractModel> list, CastomObjectArray o) {
        Integer choise;

        while (true){
            System.out.println("Выберите способ сортировки массива: \n" +
                    "1) Классическая сортировка выбором\n" +
                    "2) Модифицированная сортировка ");
            choise = UserInputInt.validUserInput();
            if (List.of(1,2).contains(choise)) break;
            else System.out.println("Указанного номера команды не существует, пожалуйста, повторите ввод");
        }
        switch (choise){
            case 1:{
                o.setSortStrategyName(NaturalSort.getSortName());
                NaturalSort.sort(list);
                break;
            }
            case 2:{

                String[] objTypeArr = list.getFirst().getClass().toString().split("\\.");
                String objType = objTypeArr[objTypeArr.length-1];
                switch (objType){
                    case "Bus":{
                        o.setSortStrategyName("Кастомная сортировка Bus (игнорируются автобусы с нечетным номером маршрута)");
                        List<Bus> busList = new ArrayList<>(list.stream().map(el -> (Bus)el).<Bus>toList());
                        new BusSortWithStrategy().strategySort(busList);
                        list.clear();
                        list.addAll(busList);
                        break;
                    }
                    case "Student":{
                        o.setSortStrategyName("Кастомная сортировка Student (игнорируются студенты с нечетным номером студенческого билета)");
                        List<Student> studentList = new ArrayList<>(list.stream().map(el -> (Student) el).<Bus>toList());
                        new StudentSortWithStrategy().strategySort(studentList);
                        list.clear();
                        list.addAll(studentList);
                        break;
                    }
                    case "User":{
                        o.setSortStrategyName("Кастомная сортировка User (нет числовых полей, сортируется в натуральном порядке)");
                        List<User> userList = new ArrayList<>(list.stream().map(el -> (User)el).<Bus>toList());
                        new UserSortWithStrategy().strategySort(userList);
                        list.clear();
                        list.addAll(userList);
                        break;
                    }
                }
            }
        }


    }
}
