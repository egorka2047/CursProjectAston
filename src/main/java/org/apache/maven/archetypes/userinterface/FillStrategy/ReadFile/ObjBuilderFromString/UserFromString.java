package org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ObjBuilderFromString;

import org.apache.maven.archetypes.classes.Bus;
import org.apache.maven.archetypes.classes.User;

import java.util.Scanner;

public class UserFromString implements ObjBuildFromString<User>{
    static String objClass = "User";

    @Override
    public String getObjClass() {
        return objClass;
    }

    @Override
    public User buildObj(String obj) {
        String name;
        String email;
        String password;

        String[] splitStr = obj.split(" ");
        name = new Scanner(splitStr[3].replace(",", "")).nextLine();
        email = new Scanner(splitStr[5].replace(",", "")).nextLine();
        password = new Scanner(splitStr[7]).nextLine();

        return User.newUserBuilder().setName(name).setEmail(email).setPassword(password).build();
    }
}
