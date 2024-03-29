package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread{

    private static volatile AtomicInteger priority = new AtomicInteger(1);

    public void maxPriority() {
        int newPriority = priority.getAndIncrement();
        newPriority = getThreadGroup() != null && newPriority > getThreadGroup().getMaxPriority() ? getThreadGroup().getMaxPriority() : newPriority;
        setPriority(newPriority);
        if (priority.intValue() > MAX_PRIORITY) {
            priority.set(1);
        }
    }

    public MyThread() {
        maxPriority();
    }

    public MyThread(Runnable task) {
        super(task);
        maxPriority();
    }

    public MyThread(ThreadGroup group, Runnable task) {
        super(group, task);
        maxPriority();
    }

    public MyThread(String name) {
        super(name);
        maxPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        maxPriority();
    }

    public MyThread(Runnable task, String name) {
        super(task, name);
        maxPriority();
    }

    public MyThread(ThreadGroup group, Runnable task, String name) {
        super(group, task, name);
        maxPriority();
    }

    public MyThread(ThreadGroup group, Runnable task, String name, long stackSize) {
        super(group, task, name, stackSize);
        maxPriority();
    }


}
