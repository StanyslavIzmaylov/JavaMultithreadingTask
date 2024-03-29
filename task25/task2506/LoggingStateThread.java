package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state1 = thread.getState();
        System.out.println(state1);
        while (true){
            State state2 = thread.getState();
            if (state1 != state2){
                System.out.println(state2);
            }
            state1=state2;
            if (state2 == State.TERMINATED){
                return;
            }
        }


    }
}
