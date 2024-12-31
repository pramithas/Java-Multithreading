package org.example.executorservice;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample7 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // Waits before all the tasks submitted to thread pool have been completed. So, it blocks the
        // main threads while all the threads are running.
        executorService.shutdown();

        // Will attempt to stop whatever tasks are currently in execution. Attempt means that it is not
        // guaranteed that the tasks will be stopped. The tasks waiting to be executed will be cancelled
        // and returned as runnable.
        List<Runnable> runnables = executorService.shutdownNow();

        try {
            // Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs,
            // or the current thread is interrupted, whichever happens first
            executorService.awaitTermination(3000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
