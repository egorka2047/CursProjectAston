package org.apache.maven.archetypes;

import org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ObjBuilderFromString.StudentFromString;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //CastomObjectArray arr = new CastomObjectArray();
        //arr.fill();
        StudentFromString studentFromString = new StudentFromString();
        System.out.println(studentFromString.buildObj("Student - groupNumber: 1, avgGrade: 1.0, gradeBookNumber: 1"));
        //System.out.println(new Scanner("1,".replace(",","")).nextDouble());



    }
}