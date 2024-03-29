package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List horses){
        this.horses = horses;

    }

    public static void main(String[] args) throws InterruptedException {
    Horse horse1 = new Horse("Kate",3,0);
    Horse horse2 = new Horse("Jane",3,0);
    Horse horse3 = new Horse("Valka",3,0);
    List<Horse> horseList = new ArrayList<>();
    horseList.add(horse1);
    horseList.add(horse2);
    horseList.add(horse3);
    Hippodrome hippodrome = new Hippodrome(horseList);
    game = hippodrome;
    game.run();
    game.printWinner();
    }
    public Horse getWinner(){
        Horse result = horses.get(0);
        for(Horse horse: horses){
            if(horse.getDistance() > result.getDistance()){
              result = horse;
            }
        }
        return result;
    }
    public void printWinner(){
    System.out.println("Winner is "+getWinner().getName()+"!");
    }
    void run() throws InterruptedException {
    for (int i = 0; i < 100; i++){
        move();
        print();
        Thread.sleep(200);
    }
    }
    void move(){
      for (Horse horse: horses){
          horse.move();
      }
    }
    void print(){
        for (Horse horse: horses){
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public List<Horse> getHorses() {
        return horses;
    }

}
