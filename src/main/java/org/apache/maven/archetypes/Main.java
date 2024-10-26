package org.apache.maven.archetypes;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.classes.Student;
import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.CastomFileReader;
import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ObjBuilderFromString.StudentFromString;
import org.apache.maven.archetypes.classes.Bus;
import org.apache.maven.archetypes.classes.Student;
import org.apache.maven.archetypes.classes.User;
import org.apache.maven.archetypes.userinterface.FillStrategy.FillStrategy;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CastomObjectArray customObjectArray = new CastomObjectArray();

        boolean running = true;

        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1. Заполнить массив данных");
            System.out.println("2. Записать пользовательские данные в файл");
            System.out.println("3. Записать отсортированные данные в файл");
            System.out.println("4. Найти элемент в отсортированной коллекции");
            System.out.println("5. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    customObjectArray.fill();
                    System.out.println("Массив данных заполнен.");
                    break;

                case 2:
                    customObjectArray.writeUserData();
                    System.out.println("Пользовательские данные записаны.");
                    break;

                case 3:
                    System.out.print("Введите имя метода сортировки: ");
                    String sortName = scanner.nextLine();
                    customObjectArray.writeSortedData(sortName);
                    System.out.println("Отсортированные данные записаны.");
                    break;

                case 4:
                    System.out.print("Введите искомый элемент (например, индекс): ");
                    int foundIndex = scanner.nextInt();
                    customObjectArray.writeSearchResult(foundIndex);
                    System.out.println("Результат поиска записан.");
                    break;

                case 5:
                    running = false;
                    System.out.println("Выход из программы.");
                    break;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
            }
        }

        scanner.close();

    }
}