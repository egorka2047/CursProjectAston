//package org.apache.maven.archetypes.writer;
//
//import org.apache.maven.archetypes.classes.AbstractModel;
//import org.apache.maven.archetypes.classes.Bus;
//import org.apache.maven.archetypes.classes.Student;
//import org.apache.maven.archetypes.classes.User;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class testMain {
//    public static void main(String[] args) {
//        UserDataWriter userDataWriter = new UserDataWriter();
//        SortedDataWriter sortedDataWriter = new SortedDataWriter();
//        WriteSearchResult writeSearchResult = new WriteSearchResult();
//        Bus bus1 = Bus.newBusBuilder().setMileage(10).setModel("One").setRoute(1).build();
//        Bus bus2 = Bus.newBusBuilder().setMileage(20).setModel("Two").setRoute(2).build();
//        Bus bus3 = Bus.newBusBuilder().setMileage(30).setModel("Three").setRoute(3).build();
//        List<Bus> busList = new ArrayList<>();
//        Collections.addAll(busList, bus1, bus2, bus3);
//
//        Student std1 = Student.newStudentBuilder().setAvgGrade(1d).setGradeBookNumber(1).setGroupNumber(1).build();
//        Student std2 = Student.newStudentBuilder().setAvgGrade(2d).setGradeBookNumber(2).setGroupNumber(2).build();
//        Student std3 = Student.newStudentBuilder().setAvgGrade(3d).setGradeBookNumber(3).setGroupNumber(3).build();
//
//        User user1 = User.newUserBuilder().setEmail("@gmail.com").setName("Igot").setPassword("132465").build();
//        User user2 = User.newUserBuilder().setEmail("@yandex.ru").setName("Sasha").setPassword("7986254").build();
//        User user3 = User.newUserBuilder().setEmail("@mail.ru").setName("Andrew").setPassword("256426").build();
//        List<User> uderList = new ArrayList<>();
//        Collections.addAll(uderList, user1, user2, user3);
//        userDataWriter.write(uderList);
////        sortedDataWriter.write(studentList, "SpecialSort");
////        writeSearchResult.write(studentList, 2);
//
//    }
//}

