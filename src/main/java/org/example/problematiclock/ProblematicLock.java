package org.example.problematiclock;

public class ProblematicLock {

    private volatile boolean locked = false;

    public static void main(String[] args) {


    }

    public void unlock() {
        this.locked = locked;
    }

    public void lock() {
        // check
        while (this.locked) {
            // busy wait. Issue is that more than 1 thread might go inside here at the same time.
        }
        // then, act
        this.locked = true;

        // Make sure that check and act are executed as single atomic operation.
    }
}
