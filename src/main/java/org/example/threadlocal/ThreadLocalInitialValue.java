package org.example.threadlocal;

public class ThreadLocalInitialValue {

    public static void main(String[] args) {

        ThreadLocal<MyObject> threadLocal = ThreadLocal.withInitial(MyObject::new);

        Thread thread1 = new Thread(() -> {
            System.out.println("threadlocal1: "+ threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("threadlocal1: "+ threadLocal.get());
        });

        thread1.start();
        thread2.start();
    }

    private static class MyObject {
    }
}
