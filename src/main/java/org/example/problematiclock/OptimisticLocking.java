package org.example.problematiclock;

import java.util.concurrent.atomic.AtomicLong;

public class OptimisticLocking {

    private AtomicLong count = new AtomicLong();

    public void inc() {
        boolean incSuccessful = false;
        while (!incSuccessful) {
            long value = this.count.get();
            long newValue = value + 1;

            incSuccessful = this.count.compareAndSet(value, newValue);
        }
    }

    public long getCount() {
        return this.count.get();
    }
}
