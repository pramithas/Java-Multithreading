package org.example.threadlocal;

public class InheritableThreadLocalExample {
    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();


        Thread thread1 =  new Thread(() -> {

            System.out.println("==== Thread1 ====");
            threadLocal.set("Thread 1 - ThreadLocal");
            inheritableThreadLocal.set("Thread 1 - InheritableThreadLocal");


            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            Thread childThread = new Thread(() -> {
                System.out.println("==== ChildThread ====");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            });

            childThread.start();
        });

        thread1.start();
    }
}
