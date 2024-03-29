package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private List<Human> children = new ArrayList<>();
    private static int nextId = 0;

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }
    public void addChild(Human human){
        children.add(human);
    }
    public void removeChild(Human human){
        children.remove(human);
    }
    public String getPosition(){
        return "Человек";
    }

    private int id;
    protected int age;
    protected String name;
    protected Size size;

    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name,int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void live() {

    }

    public int getId() {
        return id;
    }

    public void printData() {
        System.out.println(getPosition()+": " + name);
    }

    public void printSize() {
        System.out.println("Рост: " + size.getHeight() + " Вес: " + size.getWeight());
    }
    public class Size{
        public int height;
        public int weight;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Size(int height, int weight){
            this.height = height;
            this.weight = weight;
        }
    }
}