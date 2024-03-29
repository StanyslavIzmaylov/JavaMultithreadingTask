package com.javarush.task.task21.task2113;

public class Horse {
    private String name;
    private  double speed;
    private  double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    void move(){

distance += Math.random()*speed;
    }
    void print(){
        StringBuilder sb = new StringBuilder();
        for (int i =0; i<(int)distance; i++){
            sb.append(".");
        }
        System.out.println(sb+name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
