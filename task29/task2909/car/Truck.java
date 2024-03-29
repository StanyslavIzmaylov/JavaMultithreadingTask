package com.javarush.task.task29.task2909.car;

public class Truck extends Car{
    private int numberOfPassengers;
    public Truck(int numberOfPassengers) {
        super(TRUCK,numberOfPassengers);
      this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public int getMaxSpeed() {
        final int MAX_TRUCK_SPEED = 80;
        return MAX_TRUCK_SPEED;
    }
}
