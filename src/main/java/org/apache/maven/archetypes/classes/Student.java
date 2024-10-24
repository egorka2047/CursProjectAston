package org.apache.maven.archetypes.classes;

import org.apache.maven.archetypes.sort.strategySort.StudentSortWithStrategy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student extends AbstractModel<Student> {
    {
        this.sortWithStrategy = new StudentSortWithStrategy();
    }
    private Integer groupNumber;
    private Double avgGrade;
    private Integer gradeBookNumber;
    private Student() {
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }
    public Double getAvgGrade() {
        return avgGrade;
    }
    public Integer getGradeBookNumber() {
        return gradeBookNumber;
    }

    /** Созданиие объекта StudentBuilder (при создании объекта Student) **/
    public static Student.StudentBuilder newStudentBuilder() {
        return new Student().new StudentBuilder();
    }

    /** Получение объекта StudentBuilder на объекте Student (для редактирования объекта Student через StudentBuilder **/
    public Student.StudentBuilder toStudentBuilder() {
        return this.new StudentBuilder();
    }
    @Override
    public String toString() {
        return "Student - "
                + "groupNumber: " + groupNumber
                + ", avgGrade: " + avgGrade
                + ", gradeBookNumber: " + gradeBookNumber;
    }

    /** Для простоты визуального восприятия сравнение String полей реализовано как сравнение длин этих строк **/
    @Override
    public int compareTo(Student o) {
        int result = this.groupNumber.compareTo(o.groupNumber);
        if (result == 0)
            result = this.avgGrade.compareTo(o.avgGrade);
        if (result == 0)
            result = this.gradeBookNumber.compareTo(o.gradeBookNumber);
        return result;
    }

    public class StudentBuilder {
        private StudentBuilder() {}

        /** Валидными являются номера групп с 1 по 10 **/
        /* Пробрасываемые исключения - ввод типов данных, отличных от Integer
        (м.б. обработать обычным информированием в консоль о том, что объект не создан (а он не будет создан) */
        public Student.StudentBuilder setGroupNumber(Integer groupNumber) throws NumberFormatException, InputMismatchException {
            if (groupNumber >= 1 && groupNumber <= 10)
                Student.this.groupNumber = groupNumber;
            else {
                System.out.println("The entered value does not satisfy the following conditions:\n"
                        + "Group number should be Integer value (from 1 to 10)\n"
                        + "------------------------------------------------------------\n"
                        + "Enter the correct group number manually:");
                setGroupNumber(new Scanner(System.in).nextInt());
            }
            return this;
        }

        /** Валидными являются значения среднего балла от 1,0 до 5,0 **/
        /* Пробрасываемые исключения - ввод типов данных, отличных от Double
        (м.б. обработать обычным информированием в консоль о том, что объект не создан (а он не будет создан) */
        public Student.StudentBuilder setAvgGrade(Double avgGrade) throws NumberFormatException, InputMismatchException {
            if (avgGrade >= 1.0 && avgGrade <= 5.0)
                Student.this.avgGrade = avgGrade;
            else {
                System.out.println("The entered value does not satisfy the following conditions:\n"
                        + "Average grade should be Double value (from 1.0 to 5.0)\n"
                        + "------------------------------------------------------------\n"
                        + "Enter the correct average grade manually:");
                setAvgGrade(new Scanner(System.in).nextDouble());
            }
            return this;
        }

        /** Валидными являются номера зачетных книжек с 1 по 1000 **/
        public Student.StudentBuilder setGradeBookNumber(Integer gradeBookNumber) throws NumberFormatException, InputMismatchException {
            if (gradeBookNumber >= 1 && gradeBookNumber <= 1000)
                Student.this.gradeBookNumber = gradeBookNumber;
            else {
                System.out.println("The entered value does not satisfy the following conditions:\n"
                        + "Grade book number should be Integer value (from 1 to 1000)\n"
                        + "------------------------------------------------------------\n"
                        + "Enter the correct grade book number manually:");
                setGradeBookNumber(new Scanner(System.in).nextInt());
            }
            return this;
        }

        public Student build() {
            return Student.this;
        }

    }
}