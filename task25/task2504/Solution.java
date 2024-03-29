package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

import java.awt.*;
import java.util.ArrayList;

public class Solution {
    public static void processThreads(Thread... threads) {

       for (Thread thread:threads){
           switch (thread.getState()){
               case NEW:
                   thread.start();
                   break;
               case WAITING:
                   thread.interrupt();
                   break;
               case TIMED_WAITING:
                   thread.interrupt();
                   break;
               case RUNNABLE:
                   thread.isInterrupted();
                   break;
               case BLOCKED:
                   thread.interrupt();
                   break;
               case TERMINATED:
                   System.out.println(thread.getPriority());
           }
       }
    }

    public static void main(String[] args) {
    }
}
