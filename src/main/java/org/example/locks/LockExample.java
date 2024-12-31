package org.example.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String[] args) {
        // To guarantee fairness, you need to pass true argument to the constructor. In this case,
        // the threads that come to acquire lock before, are given the chance once the previous
        // thread unlocks.
        //Lock lock = new ReentrantLock(true);
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
