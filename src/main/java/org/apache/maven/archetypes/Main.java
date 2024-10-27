package org.apache.maven.archetypes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CastomObjectArray objectArray = new CastomObjectArray();

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1) Заполнить массив объектов");
            System.out.println("2) Отсортировать массив объектов");
            System.out.println("3) Сохранить исходный массив");
            System.out.println("4) Сохранить отсортированный массив");
            System.out.println("5) Выполнить бинарный поиск");
            System.out.println("6) Выход");
            System.out.print("Введите номер действия: ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    objectArray.fill();
                    System.out.println("Массив успешно заполнен.");
                    break;

                case "2":
                    objectArray.sort();
                    break;

                case "3":
                    objectArray.writeUserData();
                    break;

                case "4":
                    objectArray.writeSortedData();
                    break;

                case "5":
                    if (objectArray.search()){
                        boolean condition = true;
                        while (condition){
                            System.out.println("""
                                Хотите сохранить результаты поиска ?
                                1) Да
                                2) Нет""");
                            choice = scanner.nextLine();
                            switch (choice){
                                case "1":{
                                    objectArray.writeSearchResult();
                                    System.out.println("Результат поиска записан.");
                                    condition = false;
                                    break;
                                }
                                case "2":{
                                    condition = false;
                                    break;
                                }
                                default:
                                    System.out.println("Введен неверный номер команды");
                            }

                        }
                    }


                    break;

                case "6":
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
