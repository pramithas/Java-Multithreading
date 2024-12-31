package org.example.blockingqueue.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // take(): blocks until an element is available.
                // poll(): Return if there is an element, otherwise returns null.
                // poll() with timeout: If there is element, return immediately. Otherwise, wait for
                // the timeout duration and then return null if there still no element present.
                // remove() - remove the element from blocking queue.
                String message = this.blockingQueue.take();
                System.out.println(Thread.currentThread().getName() +" consumed: "+ message);
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
