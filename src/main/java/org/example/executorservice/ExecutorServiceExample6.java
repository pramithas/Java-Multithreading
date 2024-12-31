package org.example.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample6 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallables("Task 1.1"));
        callables.add(newCallables("Task 1.2"));
        callables.add(newCallables("Task 1.3"));

        try {
            List<Future<String>> result = executorService.invokeAll(callables);
            for (Future<String> future : result) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }

    private static Callable<String> newCallables(String taskName) {
        return () -> Thread.currentThread().getName() + " executing " + taskName;
    }
}
