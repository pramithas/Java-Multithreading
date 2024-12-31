package org.example.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceExample8 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(newCallables("Task 1.1"));

        System.out.println(future.isDone());
        boolean cancel = true;

        boolean wasCancelled = future.cancel(cancel);
        System.out.println(wasCancelled);

        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } catch (CancellationException e) {
            String msg = "Cannot call get() method because the future was cancelled.";
            System.out.println(msg);
        }

        System.out.println(future.isDone());
        executorService.shutdown();
    }

    private static Callable<String> newCallables(String taskName) {
        return () -> Thread.currentThread().getName() + " executing " + taskName;
    }
}
