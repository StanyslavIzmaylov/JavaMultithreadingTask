package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private final String name;
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    private boolean busy;

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) {
        this.busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        int timeCooking = order.getTotalCookingTime();
        CookedOrderEventDataRow row = new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes());
        StatisticManager.getInstance().register(row);
        try {
            Thread.sleep(timeCooking*10 );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        setChanged();
        notifyObservers(order);
        this.busy = false;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(10);
                if (!queue.isEmpty()) {
                    if (!this.isBusy()) {
                        this.startCookingOrder(queue.take());
                    }
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
