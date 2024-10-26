package org.apache.maven.archetypes;


import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.classes.User;
import org.apache.maven.archetypes.fillingAnArray.RandomArrayFilling;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CastomObjectArray arr = new CastomObjectArray();
        arr.fill();
        arr.writeUserData();


    }
}