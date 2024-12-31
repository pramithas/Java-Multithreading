package org.example.raceconditions;

public class CounterSynchronized {

    private long count = 0;

    public synchronized long incAndGet() {
        // Critical section where the race condition might happen.
        this.count++;
        return this.count;
    }

    public long get() {
        synchronized (this) {
            return this.count;
        }
    }
}
