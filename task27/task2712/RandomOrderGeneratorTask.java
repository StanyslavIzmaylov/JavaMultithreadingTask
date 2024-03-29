package com.javarush.task.task27.task2712;

import java.util.LinkedList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable{
   private List<Tablet> tabletList;
   private int randomTanlet;

    public RandomOrderGeneratorTask(List<Tablet> tabletList, int randomTanlet) {
        this.tabletList = tabletList;
        this.randomTanlet = randomTanlet;
    }

    @Override
        public void run() {
        while (true){
            int random = (int) (Math.random()*100);
            tabletList.get(random);

        }
    }
}
