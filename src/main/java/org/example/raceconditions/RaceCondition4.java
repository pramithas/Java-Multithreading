package org.example.raceconditions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Check then act race condition.
 */
public class RaceCondition4 {

    public static void main(String[] args) {

        Map<String, String> sharedMap = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(getRunnable(sharedMap));
        Thread thread2 = new Thread(getRunnable(sharedMap));

        thread1.start();
        thread2.start();
    }

    private static Runnable getRunnable(Map<String, String> sharedMap) {

        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                // if both threads come here at the same time, both enter inside if. And, hashmap won't
                // allow remove operation for both of the threads. So, for the thread that is denied,
                // val is equal to null.
                synchronized (RaceCondition4.class) {
                    if (sharedMap.containsKey("key")) {
                        String val = sharedMap.remove("key");
                        if (val == null) {
                            System.out.println("Value for 'key' was null");
                        }
                    } else {
                        sharedMap.put("key", "value");
                    }
                }
            }
        };
    }
}
