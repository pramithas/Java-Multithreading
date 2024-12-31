package org.example.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample3 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future future = executorService.submit(getRunnable("Task 1"));

        System.out.println(future.isDone());

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(future.isDone());
        executorService.shutdown();
    }

    private static Runnable getRunnable(String taskName) {
        return () -> {
            String currentThread = Thread.currentThread().getName();
            System.out.println(currentThread + " is executing " + taskName);
        };
    }
}
