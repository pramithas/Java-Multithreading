package org.example;

import java.util.ArrayList;
import java.util.List;

public class VirtualThread2 {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        int vThreadCount =  100_000;

        for (int i = 0; i < vThreadCount; i++) {
            int vThreadIndex = i;

            Thread vThread = Thread.ofVirtual().start(() -> {
                int result = 1;
                for (int j = 0; j < 10; j++) {
                    result *= (j + 1);
                }
                System.out.println("Result[" + vThreadIndex + "]: "+ result);
            });

            threads.add(vThread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
