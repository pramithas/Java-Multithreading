package org.example.deadlock.locks;

import java.util.concurrent.locks.Lock;

public class Runnable2 implements Runnable {

    private Lock lock1 = null;
    private Lock lock2 = null;

    public Runnable2(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + " attempting to lock lock2");
        lock2.lock();
        System.out.println(threadName + " locked lock2");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(threadName + " attempting to lock lock1");
        lock1.lock();
        System.out.println(threadName + " locked lock1");

        // Do some work after locking both threads.

        System.out.println(threadName + " attempting to unlock lock2");
        lock2.unlock();
        System.out.println(threadName + " attempting to unlock lock1");
        lock1.unlock();
    }
}
