package org.example;

public class VirtualThread {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Index: "+ i);
            }
        };

        // Create and start immediately.
        Thread vThread =  Thread.ofVirtual().name("t1").start(runnable);

        Thread vThreadUnstarted = Thread.ofVirtual().unstarted(runnable);
        vThreadUnstarted.start();

        try {
            vThreadUnstarted.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
