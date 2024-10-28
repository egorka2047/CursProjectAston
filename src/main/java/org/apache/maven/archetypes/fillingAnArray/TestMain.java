//package org.apache.maven.archetypes.fillingAnArray;
//
//
//import org.apache.maven.archetypes.classes.AbstractModel;
//import org.apache.maven.archetypes.classes.Bus;
//import org.apache.maven.archetypes.classes.Student;
//import org.apache.maven.archetypes.classes.User;
//
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestMain {
//
//    public static void main(String[] args) throws FileNotFoundException {
//// В основном мейне  в ветке условий пользователь выбирает  какого типа хочет создать список, в зависимости от его
//// выбора реальзуются разные мотоды
//
//
//// чтение из файлов
//
//        List<AbstractModel> listStudent = FillingAnArrayFromFile.getArrayOjects(Student.newStudentBuilder().build());
//        System.out.println(listStudent.size());
//
//        List<AbstractModel> listBus = FillingAnArrayFromFile.getArrayOjects(Bus.newBusBuilder().build());
//        System.out.println(listBus.size());
//
//        List<AbstractModel> listUser = FillingAnArrayFromFile.getArrayOjects(User.newUserBuilder().build());
//        System.out.println(listUser.size());
//
//        System.out.println("--------------------------------------------");
//
////Приведение типов. (это на всякий случай)
//
//        List<User> userArrayList =  new ArrayList<>();
//        listUser.forEach(i->userArrayList.add((User) i));
//
//// тест ручного заполнения
//// проверки на правильность  введеных значений тут нет
//
//
//        List<Student> studentList = new ArrayList<>();
//        ManualFillingOfTheArray.addToListStudent(studentList,12,4.3,4);
//        ManualFillingOfTheArray.addToListStudent(studentList,12,4.3,4);
//       // System.out.println(studentList.size());
//
//        List<Bus> busList = new  ArrayList<>();
//        ManualFillingOfTheArray.addToListBus(busList,23,"Maz",2);
//        ManualFillingOfTheArray.addToListBus(busList,23,"Maz",2);
//        ManualFillingOfTheArray.addToListBus(busList,23,"Maz",2);
//        ManualFillingOfTheArray.addToListBus(busList,23,"Maz",2);
//        //System.out.println(busList.size());
//
//        List<User> userList = new  ArrayList<>();
//        ManualFillingOfTheArray.addToListUser(userList,"Bob","bob@mail.ru","123w");
//        ManualFillingOfTheArray.addToListUser(userList,"Bob","bob@mail.ru","123w");
//        ManualFillingOfTheArray.addToListUser(userList,"Bob","bob@mail.ru","123w");
//       //System.out.println(userList.size());
//
//
//        System.out.println("--------------------------------------------");
//
//        // тест рандомного заполнения
//
//        // в зависимости от выбора пользователя выбираются методы (можно эти строчки  прям в цикл скопировать)
//
//
//       List<Bus> busListRandom = new  ArrayList<>();
//       RandomArrayFilling.createList(Bus.newBusBuilder().build(), 3).forEach(i->busListRandom.add((Bus) i));
//
//       System.out.println(busListRandom.size());
//
//       List<Student> studentListRandom = new ArrayList<>();
//       RandomArrayFilling.createList(Student.newStudentBuilder().build(), 5).forEach(i->studentListRandom.add((Student) i));
//
//        System.out.println(studentListRandom.size());
//
//
//        List<User> userListRandom = new ArrayList<>();
//        RandomArrayFilling.createList(User.newUserBuilder().build(), 6).forEach(i -> userListRandom.add((User) i));
//
//        userListRandom.forEach(System.out::println);
//
//    }
//
//}
