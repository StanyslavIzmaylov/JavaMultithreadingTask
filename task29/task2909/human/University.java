package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class University {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    private List<Student> students = new ArrayList<>();
    public University(String name,int age) {
      this.name = name;
      this.age = age;
    }

    public Student getStudentWithAverageGrade(double grade) {
        //TODO:
        for (Student student : students) {
            double newGrade = student.getAverageGrade();
            if (newGrade == grade)
                return student;;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        return Collections.max(students, Comparator.comparingDouble(Student::getAverageGrade));
    }

    public Student  getStudentWithMinAverageGrade() {
        //TODO:
        return Collections.min(students, Comparator.comparingDouble(Student::getAverageGrade));
    }
    public void expel(Student student){
        students.remove(student);
    }
}