package com.javarush.task.task29.task2909.car;

public class Cabriolet extends Car{
    private int numberOfPassengers;
    public Cabriolet(int numberOfPassengers) {
        super(CABRIOLET,numberOfPassengers);
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_CABRIOLET_SPEED = 90;
        return MAX_CABRIOLET_SPEED;
    }
}
