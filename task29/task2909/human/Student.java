package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {

    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Student(String name, int age, double averageGrade) {
        super(name,age);
        this.averageGrade = averageGrade;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }

    public void live() {
        learn();
    }

    public void learn() {
    }




    public void incAverageGrade(double delta){
      averageGrade = getAverageGrade();
      averageGrade+=delta;
      setAverageGrade(averageGrade);
    }

    public void setCourse(){

    }
    public void setAverageGrade(double averageGrade){
        this.averageGrade = averageGrade;
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}