package org.example.blockingqueue.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            long timeMillis = System.currentTimeMillis();
            try {
                // put(): blocks until there is a space inside the blocking queue.
                // add(): Add will not block but will throw illegal state exception.
                // offer(): Won't block and won't throw exception either.It will just return a
                // boolean whether the element was enqueued or not.
                // offer() with timeout: Will not immediately return if there is no space. But, will wait
                // for the timeout interval.
                this.blockingQueue.put(""+ timeMillis);
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted.");
            }
            sleep(1000);
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
