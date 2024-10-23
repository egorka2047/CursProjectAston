package org.apache.maven.archetypes.writer;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractWriter {
    File file;
    String catalog, fileName;

     void setCatalog(){
        String catalog;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите каталог, куда желаете записать файл: ");
            File file = new File(catalog = sc.nextLine());
            if (!file.isDirectory()) {
                System.out.println("Указанного каталога не существует, пожалуйста, повторите ввод");
            } else if (!catalogAccess.writeAccessible(file)){
                System.out.println("Нет прав на запись в указанной директории");
            } else {
                this.catalog = catalog;
                break;
            }
        }
    }






}
