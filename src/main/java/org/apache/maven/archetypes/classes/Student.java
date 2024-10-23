package org.apache.maven.archetypes.classes;

public class Student extends AbstractModel<Student> {
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

    public static Student.StudentBuilder newStudentBuilder() {
        return new Student().new StudentBuilder();
    }

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

    /* Для простоты визуального восприятия сравнение String полей пока что реализовано как сравнение длин этих строк */

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

        public Student.StudentBuilder setGroupNumber(Integer groupNumber) {
            Student.this.groupNumber = groupNumber;
            return this;
        }

        public Student.StudentBuilder setAvgGrade(Double avgGrade) {
            Student.this.avgGrade = avgGrade;
            return this;
        }

        public Student.StudentBuilder setGradeBookNumber(Integer gradeBookNumber) {
            Student.this.gradeBookNumber = gradeBookNumber;
            return this;
        }

        public Student build() {
            return Student.this;
        }

    }
}
