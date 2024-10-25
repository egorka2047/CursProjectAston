package org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile;

import org.apache.maven.archetypes.writer.AbstractFileWriter;
import org.apache.maven.archetypes.writer.catalogAccess;

import java.io.File;
import java.util.Scanner;

public interface ChoiceCatalog {

    static void setCatalog(ValidFileFinder fileFinder){
        String catalog;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Введите каталог, куда желаете записать файл: ");
            File file = new File(catalog = sc.nextLine());

            if (!file.isDirectory()) {
                System.out.println("Указанного каталога не существует, пожалуйста, повторите ввод");
            }
            else {
                fileFinder.setCatalog(catalog);
                break;
            }
        }
    }
}
