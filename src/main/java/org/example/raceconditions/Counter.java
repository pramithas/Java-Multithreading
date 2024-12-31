package org.example.raceconditions;

public class Counter {

    private long count = 0;

    public long incAndGet() {
        // Critical section where the race condition might happen.
        this.count++;
        return this.count;
    }

    public long get() {
        return this.count;
    }
}
