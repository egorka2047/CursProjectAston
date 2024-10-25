package org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ObjBuilderFromString.BusFromString;
import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ObjBuilderFromString.ObjBuildFromString;
import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ObjBuilderFromString.StudentFromString;
import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ObjBuilderFromString.UserFromString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CastomFileReader {

    static List<String> availableClasses = List.of("Bus", "Student", "User");
    static List<? extends ObjBuildFromString<?>> availableObjBuilder = List.of(new BusFromString(), new StudentFromString(), new UserFromString());

    public static void read(File file, List<? super AbstractModel<?>> userObjectList){

        try(FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String[] firstLine = bufferedReader.readLine().split(" ");
            String objClass = firstLine[firstLine.length-1];
            String[] secondLine = bufferedReader.readLine().split(" ");
            if (!availableClasses.contains(objClass)) {
                throw new IOException("Файл не подходит для считывания данных");
            }
            Integer numObj = Integer.parseInt(secondLine[secondLine.length-1]);
            Optional<? extends ObjBuildFromString> objBuilderOpt = availableObjBuilder.stream().filter(el -> el.getObjClass().equals(objClass)).findFirst();
            if (objBuilderOpt.isPresent()){
                ObjBuildFromString<? extends AbstractModel<?>> objBuilder = objBuilderOpt.get();
                for (int i = 0; i < numObj; i++) {
                    userObjectList.add(objBuilder.buildObj(bufferedReader.readLine()));
                }
            }
            else throw new IOException("Файл не подходит для считывания данных");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());

        }
    }
}
