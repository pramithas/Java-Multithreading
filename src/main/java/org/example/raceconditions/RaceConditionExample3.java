package org.example.raceconditions;

/**
 * Two threads are modifying two different objects.
 */
public class RaceConditionExample3 {

    public static void main(String[] args) throws InterruptedException {

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        Thread thread1 = new Thread(getRunnable(counter1, counter2, "Thread 1"));
        Thread thread2 = new Thread(getRunnable(counter1, counter2, "Thread 2"));

        thread1.start();
        thread2.start();
    }

    private static Runnable getRunnable(Counter counterA, Counter counterB, String runnableName) {

        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counterA.incAndGet();
            }
            System.out.println(runnableName + " final count - counterA: "+ counterA.get());
            System.out.println(runnableName + " final count - counterB: "+ counterB.get());
        };
    }
}
