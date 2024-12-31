package org.example;

public class SharedObjects {

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
