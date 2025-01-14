package org.example;

public class MyRunnable implements Runnable {

    private int count = 0;

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                this.count++;
            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + this.count);
    }
}
