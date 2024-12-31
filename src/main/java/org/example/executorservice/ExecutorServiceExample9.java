package org.example.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample9 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    }
    }
