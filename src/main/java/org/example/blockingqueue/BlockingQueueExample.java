package org.example.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        try {
            blockingQueue.put("element 1");
            blockingQueue.put("element 2");

            String element1 = blockingQueue.take();
            String element2 = blockingQueue.take();

            System.out.println(element1);
            System.out.println(element2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
