package org.example;

public class Example3 {

    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("MyThread running");
//                System.out.println("MyThread finished");
//            }
//        };
        // anonymous inner class replaced by lambda expression.
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+" running");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(threadName+" stopped");
        };

        Thread thread0 = new Thread(runnable, "Thread1");
        thread0.start();
        Thread thread1 = new Thread(runnable, "Thread2");
        thread1.start();
    }
}
