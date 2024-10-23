package org.apache.maven.archetypes.writer;

import org.apache.maven.archetypes.classes.AbstractModel;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractWriter {
    File file;
    String catalog, fileName;

    abstract void  write(List<? extends AbstractModel<?>> list);

    public void setCatalog(){
        String catalog;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите каталог, куда желаете записать файл: ");
            if (!(new File(catalog = sc.nextLine())).isDirectory()) {
                System.out.println("Указанного каталога не существует, пожалуйста, повторите ввод");
            } else{
                this.catalog = catalog;
                break;
            }
        }
    }
    public void setFieName(){
        if (catalog == null){
            System.out.println("Сначала необходимо выбрать каталог для сохранения!");
            this.setCatalog();
        }
        String fileName;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Введите желаемое имя файла: ");
            fileName = sc.nextLine();
            if ((new File(this.catalog +"\\" +fileName).exists())) {
                System.out.printf("Файл %s уже существует в каталоге %s, пожалуйста, введите другое имя файла\n", fileName, catalog);
            } else {
                this.fileName = fileName;
                break;
            }
        }
        this.file = new File(catalog +"\\" + fileName);

    }


    public File getFile() {
        if (file != null) return file;
        else {
            this.setFieName();
            return this.file;
        }
    }



}
