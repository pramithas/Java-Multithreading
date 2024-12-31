package org.example.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceExample4 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(getCallable("Task 1"));

        System.out.println(future.isDone());

        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(future.isDone());
        executorService.shutdown();
    }

    private static Callable<String> getCallable(String taskName) {
        return () -> Thread.currentThread().getName() + " is executing " + taskName;
    }
}
