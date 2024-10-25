package org.apache.maven.archetypes.validators;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentValidator {

    /** Валидным является номер группы с 1 по 10 **/
    public static Integer studentGroupNumberValidate(Integer groupNumber) throws InputMismatchException {
        if (groupNumber >= 1 && groupNumber <= 10)
            return groupNumber;
        else {
            System.out.println("The entered value does not satisfy the following conditions:\n"
                    + "Group number should be Integer value (from 1 to 10)\n"
                    + "------------------------------------------------------------\n"
                    + "Enter the correct Group number manually:");
            return studentGroupNumberValidate(new Scanner(System.in).nextInt());
        }
    }

    /** Валидным является значение среднего балла от 1,0 до 5,0 **/
    public static Double studentAvgGradeValidate(Double avgGrade) throws InputMismatchException {
        if (avgGrade >= 1.0 && avgGrade <= 5.0)
            return avgGrade;
        else {
            System.out.println("The entered value does not satisfy the following conditions:\n"
                    + "Average grade should be Double value (from 1.0 to 5.0)\n"
                    + "------------------------------------------------------------\n"
                    + "Enter the correct Average grade manually:");
            return studentAvgGradeValidate(new Scanner(System.in).nextDouble());
        }
    }

    /** Валидными являются номера зачетных книжек с 1 по 1000 **/
    public static Integer studentGradeBookNumberValidate(Integer gradeBookNumber) throws InputMismatchException {
        if (gradeBookNumber >= 1 && gradeBookNumber <= 1000)
            return gradeBookNumber;
        else {
            System.out.println("The entered value does not satisfy the following conditions:\n"
                    + "Grade book number should be Integer value (from 1 to 1000)\n"
                    + "------------------------------------------------------------\n"
                    + "Enter the correct Grade book number manually:");
            return studentGradeBookNumberValidate(new Scanner(System.in).nextInt());
        }
    }
}