package org.example.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(newRunnable("Task 1"));
        executorService.execute(newRunnable("Task 2"));
        executorService.execute(newRunnable("Task 3"));

        executorService.shutdown();
    }

    private static Runnable newRunnable(String msg) {
        return () -> {
            String completeMsg = Thread.currentThread().getName() + ": " + msg;
            System.out.println(completeMsg);
        };
    }
}
