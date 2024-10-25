package org.apache.maven.archetypes.classes;

import org.apache.maven.archetypes.sort.strategySort.StudentSortWithStrategy;
import org.apache.maven.archetypes.validators.StudentValidator;
import java.util.InputMismatchException;

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

        public Student.StudentBuilder setGroupNumber(Integer groupNumber) throws InputMismatchException {
            Student.this.groupNumber = StudentValidator.studentGroupNumberValidate(groupNumber);
            return this;
        }

        public Student.StudentBuilder setAvgGrade(Double avgGrade) throws InputMismatchException {
            Student.this.avgGrade = StudentValidator.studentAvgGradeValidate(avgGrade);
            return this;
        }

        public Student.StudentBuilder setGradeBookNumber(Integer gradeBookNumber) throws InputMismatchException {
            Student.this.gradeBookNumber = StudentValidator.studentGradeBookNumberValidate(gradeBookNumber);
            return this;
        }

        public Student build() {
            return Student.this;
        }
    }
}