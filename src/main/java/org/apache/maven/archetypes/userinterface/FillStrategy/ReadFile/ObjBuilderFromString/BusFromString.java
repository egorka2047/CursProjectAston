package org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ObjBuilderFromString;

import org.apache.maven.archetypes.classes.Bus;
import org.apache.maven.archetypes.classes.Student;

import java.util.Scanner;

public class BusFromString implements ObjBuildFromString<Bus> {
    static String objClass = "Bus";

    @Override
    public String getObjClass() {
        return objClass;
    }

    @Override
    public Bus buildObj(String obj) {
        Integer route;
        String model;
        Integer mileage;

        String[] splitStr = obj.split(" ");
        route = new Scanner(splitStr[3].replace(",", "")).nextInt();
        model = new Scanner(splitStr[5].replace(",", "")).nextLine();
        mileage = new Scanner(splitStr[7]).nextInt();

        return Bus.newBusBuilder().setRoute(route).setModel(model).setMileage(mileage).build();
    }
}
