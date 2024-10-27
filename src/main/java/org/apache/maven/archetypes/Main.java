package org.apache.maven.archetypes;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.search.universalsearch.BinarySearch;
import org.apache.maven.archetypes.sort.strategySort.SortWithStrategy;
import org.apache.maven.archetypes.sort.NaturalSort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CastomObjectArray objectArray = new CastomObjectArray();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1) Заполнить массив объектов");
            System.out.println("2) Отсортировать массив объектов");
            System.out.println("3) Сохранить исходный массив");
            System.out.println("4) Сохранить отсортированный массив");
            System.out.println("5) Выполнить бинарный поиск");
            System.out.println("6) Выход");
            System.out.print("Введите номер действия: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    objectArray.fill();
                    System.out.println("Массив успешно заполнен.");
                    break;

                case 2:
                    // needs sort
                    System.out.println("Массив успешно отсортирован.");
                    break;

                case 3:
                    objectArray.writeUserData();
                    System.out.println("Исходный массив сохранен.");
                    break;

                case 4:
                    System.out.print("Введите название метода сортировки: ");
                    String sortName = scanner.next();
                    objectArray.writeSortedData(sortName);
                    System.out.println("Отсортированный массив сохранен.");
                    break;

                case 5:
                    System.out.print("Введите искомый элемент (например, индекс): ");
                    int foundIndex = scanner.nextInt();
                    objectArray.writeSearchResult(foundIndex);
                    System.out.println("Результат поиска записан.");
                    break;

                case 6:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный ввод, попробуйте снова.");
                    break;
            }
        }
    }
}
