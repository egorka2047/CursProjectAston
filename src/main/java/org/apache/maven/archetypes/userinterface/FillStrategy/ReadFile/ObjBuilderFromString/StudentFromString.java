package org.apache.maven.archetypes.userinterface.FillStrategy.ReadFile.ObjBuilderFromString;

import org.apache.maven.archetypes.classes.Student;

import java.util.Scanner;

public class StudentFromString implements ObjBuildFromString<Student>{
    static String objClass = "Student";

    @Override
    public String getObjClass() {
        return this.objClass;
    }

    @Override
    public Student buildObj(String obj) {
        Integer groupNumber;
        Double avgGrade;
        Integer gradeBookNumber;

        String[] splitStr = obj.split(" ");
        groupNumber = new Scanner(splitStr[3].replace(",", "")).nextInt();
        avgGrade = new Scanner(splitStr[5].replace(",", "").replace(".", ",")).nextDouble();
        gradeBookNumber = new Scanner(splitStr[7]).nextInt();

        return Student.newStudentBuilder().setGroupNumber(groupNumber).setAvgGrade(avgGrade).setGradeBookNumber(gradeBookNumber).build();
    }
}
