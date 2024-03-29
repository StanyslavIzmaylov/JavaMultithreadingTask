package com.javarush.task.task30.task3003;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;


public class Producer implements Runnable{
    private TransferQueue <ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {


          for (int i = 1; i <= 9; i ++){
              System.out.format("Элемент 'ShareItem-"+i+"' добавлен ");
              queue.offer(new ShareItem("ShareItem-",i));
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
              if (queue.hasWaitingConsumer()) {
                  System.out.format("Consumer в ожидании!\n");
              }
      }
    }
}
