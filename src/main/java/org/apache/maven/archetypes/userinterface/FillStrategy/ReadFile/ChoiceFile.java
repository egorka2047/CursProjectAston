package org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile;

import java.io.File;
import java.util.Scanner;

public interface ChoiceFile {
    static void setFieName(ValidFileFinder fileFinder){
        String fileName;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Введите название искомого файла: ");
            fileName = sc.nextLine();
            File file = new File(fileFinder.getCatalog() +"\\" +fileName);
            if (!(file.exists())) {
                System.out.printf("Файл %s не существует в каталоге %s, пожалуйста, введите другое имя файла\n", fileName, fileFinder.getCatalog());
            }
            else {
                fileFinder.setFileName(fileName);
                break;
            }
        }
    }

    static void setFile(ValidFileFinder fileFinder) {
        setFieName(fileFinder);
        fileFinder.setFile(new File(fileFinder.getCatalog() +"\\" + fileFinder.getFileName()));
    }
}
