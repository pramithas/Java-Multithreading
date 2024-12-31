package org.example.blockingqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueMethods {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

        Collection dest = new ArrayList<>();
        blockingQueue.drainTo(dest);
        blockingQueue.drainTo(dest, 5);

        String element1 = blockingQueue.peek();
        try {
            String element2 = blockingQueue.element();
        }catch (NoSuchElementException e) {
            System.out.println("Blockingqueue is empty.");
        }


        int size = blockingQueue.size();
        int remainingCapacity = blockingQueue.remainingCapacity();
        boolean containsElement = blockingQueue.contains("1");

    }
}
