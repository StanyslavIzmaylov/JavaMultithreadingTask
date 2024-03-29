package com.javarush.task.task29.task2909.car;

public class Sedan extends Car {
    private int numberOfPassengers;
    public Sedan(int numberOfPassengers) {
        super(SEDAN,numberOfPassengers);
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_SEDAN_SPEED = 120;
        return MAX_SEDAN_SPEED;
    }
}
