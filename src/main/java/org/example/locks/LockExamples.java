package org.example.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExamples {

    public static void main(String[] args) {
        lockBasics();
    }

    private static void lockBasics() {

        ReentrantLock lock = new ReentrantLock(false);

        Runnable runnable = () -> {
            lockSleepUnlock(lock, 1000);
        };

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void lockSleepUnlock(ReentrantLock lock, long timeMillis) {
        try {
            lock.lock();
            printThreadMsg(" holds the lock. The queue length is: "+ lock.getQueueLength());
            sleep(timeMillis);
        } finally {
            lock.unlock();
        }
    }

    private static void printThreadMsg(String msg) {
        System.out.println(Thread.currentThread().getName() + msg);
    }

    private static void sleep(long timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void lockInterruptibly() {
        Lock lock = new ReentrantLock();
        Thread.currentThread().interrupt();

        try {
            //Acquires the lock unless the current thread is interrupted.
            lock.lockInterruptibly();
            lock.unlock();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    private void tryLock() {
        Lock lock = new ReentrantLock();
        try {
            // Does not block, if the lock is not available, just return false and goes on doing its thing
            // until the lock is available. Try lock won't respect fairness even though we set to true in the
            // constructor.
            try {
                // waits until the given timeout for lock availability.
                boolean lockSuccessful = lock.tryLock(1000, TimeUnit.MILLISECONDS);
                System.out.println("Lock successful: " + lockSuccessful);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } finally {
            lock.unlock();
        }
    }
}