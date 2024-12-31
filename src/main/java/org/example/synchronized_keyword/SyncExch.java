package org.example.synchronized_keyword;

/**
 * Limitations of syn block:
 *
 * 1. Only one thread can enter a syn block at a time.(you might only want to block multiple write access not reads)
 * 2. There is no guarantee about the sequence in which waiting threads gets access to the
 *    synchronized block.
 *
 *
 *    One thread can only block another inside the same VM.
 */
public class SyncExch {

    private long count = 0;
    private Object obj = null;

    public void set(Object o) {
        synchronized (this) {
            // Both the values will be read from memory and written back to as well.
            this.count++;
            this.obj = o;
        }

        /**
         * The values for both will be read written at last to memory but the count might be read from cache.
         *
         * this.count++;
         * synchronized(this) {
         *     this.obj = o;
         * }

         /**
           * The values for both will be read from memory
           * but the count won't be written back to memory.

           * synchronized(this) {
           *     this.obj = o;
           * }
         *    this.count++;
         */
    }

    public Object get() {
        synchronized (this) {
            return this.obj;
        }
    }
}
