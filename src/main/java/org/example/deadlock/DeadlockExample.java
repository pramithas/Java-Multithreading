package org.example.deadlock;

import org.example.deadlock.locks.Runnable1;
import org.example.deadlock.locks.Runnable2;
import org.example.deadlock.sync.RunnableSync1;
import org.example.deadlock.sync.RunnableSync2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Cause of deadlock:
 * 1. Mutual exclusion.
 * 2. No preemption: Once a thread has locked a lock, it cannot pre-empted and release the lock.
 * 3. Hold and wait: Thread holds a lock and waits for other locks.
 * 4. Circular Wait: As shown in the example.
 *
 *
 * Other problems similar to deadlock:
 *  a. Livelock.
 *  b. Nested Monitor Lockout.
 *  c. Reentrance Lockout.
 *  d. Starvation.
 */
public class DeadlockExample {

    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

//        Runnable runnable1 = new Runnable1(lock1, lock2);
//        Runnable runnable2 = new Runnable2(lock1, lock2);

        Runnable runnable1 = new RunnableSync1(lock1, lock2);
        Runnable runnable2 = new RunnableSync2(lock1, lock2);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }
}
