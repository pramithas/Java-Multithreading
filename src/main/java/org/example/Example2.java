package org.example;

public class Example2 {
    public static class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println("MyThread running");
            System.out.println("MyThread finished");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();
    }
}
