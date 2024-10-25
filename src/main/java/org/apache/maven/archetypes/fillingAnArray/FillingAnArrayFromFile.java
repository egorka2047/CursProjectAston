package org.apache.maven.archetypes.fillingAnArray;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.classes.Bus;
import org.apache.maven.archetypes.classes.Student;
import org.apache.maven.archetypes.classes.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class FillingAnArrayFromFile {

//Функция выбора файла для чтения
        private static Scanner createFile(AbstractModel T) throws FileNotFoundException {
           String nameFile =" ";
           // сравниваем полученый класс с условиями
   if(T.getClass() ==Student.class) nameFile = "ListOfStudents";
   if(T.getClass() == Bus.class) nameFile = "ListOfBus";
   if (T.getClass() == User.class) nameFile = "ListOfUser";
   File file = new File(nameFile);
        return    new Scanner(file);
}
 // Создаёт лист объектов
        public static List<AbstractModel> getArrayOjects(AbstractModel T) throws FileNotFoundException {

            List<AbstractModel> list = new ArrayList<>();

            if (T.getClass() == Student.class) {
                System.out.println("Student");
                Scanner scanner = createFile(T);
                while (scanner.hasNextLine()) {

                    // Создаётся массив из строк (убираем "," ,сепоратор " "

                    String[] splitLinesArray = scanner.nextLine().replace(",", " ").split(" ");
                    // временные переменные
                    Integer groupNumber = Integer.parseInt(splitLinesArray[3]);
                    Double avgGrade = Double.parseDouble(splitLinesArray[6]);
                    Integer gradeBookNumber = Integer.parseInt(splitLinesArray[9]);
                 //   Создаём экзкмпляр объекта и кладём в список
                    Student student = Student.newStudentBuilder().setGroupNumber(groupNumber).setGradeBookNumber(gradeBookNumber).setAvgGrade(avgGrade).build();
                    list.add(student);
                }
                scanner.close();

            }if (T.getClass() == Bus.class){
                System.out.println("Bus");
                Scanner scanner = createFile(T);

                while (scanner.hasNextLine()) {
                    String[] splitLinesArray = scanner.nextLine().replace(",", " ").split(" ");
                    Integer route = Integer.parseInt(splitLinesArray[3]);
                    String model = splitLinesArray[6];
                    Integer mileage = Integer.parseInt(splitLinesArray[9]);
                    Bus bus = Bus.newBusBuilder().setMileage(mileage).setModel(model).setRoute(route).build();
                    list.add(bus);
                }
                      scanner.close();

            } if (T.getClass() == User.class) {
                System.out.println("User");
                Scanner scanner = createFile(T);

                while (scanner.hasNextLine()) {
                    String[] splitLinesArray = scanner.nextLine().replace(",", " ").split(" ");
                    String name = splitLinesArray[3];
                    String email = splitLinesArray[6];
                    String password = splitLinesArray[9];
                    User user = User.newUserBuilder().setName(name).setEmail(email).setPassword(password).build();
                    list.add(user);

                }
                scanner.close();
            }
            return list;
        }

}
