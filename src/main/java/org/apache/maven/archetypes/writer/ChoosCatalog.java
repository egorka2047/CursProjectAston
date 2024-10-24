package org.apache.maven.archetypes.writer;

import java.io.File;
import java.util.Scanner;

/**Класс позволяет установить паарметр catalog для любого класса, наследующего AbstractFileWriter
 * Гарантируется, что установленный каталог существует и имется возможность для создания файлов**/

public  interface ChoosCatalog {

     default void setCatalog(AbstractFileWriter wrt){

        String catalog;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Введите каталог, куда желаете записать файл: ");
            File file = new File(catalog = sc.nextLine());

            if (!file.isDirectory()) {
                System.out.println("Указанного каталога не существует, пожалуйста, повторите ввод");
            }
            else if (!catalogAccess.writeAccessible(file)){
                System.out.println("Нет прав на запись в указанной директории");
            }
            else {
                wrt.catalog = catalog;
                break;
            }
        }
    }






}
