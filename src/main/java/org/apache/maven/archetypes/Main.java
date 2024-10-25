package org.apache.maven.archetypes;

import org.apache.maven.archetypes.classes.AbstractModel;
import org.apache.maven.archetypes.classes.Student;
import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.CastomFileReader;
import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ObjBuilderFromString.StudentFromString;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CastomObjectArray arr = new CastomObjectArray();
        arr.fill();
        arr.writeUserData();

    }
}