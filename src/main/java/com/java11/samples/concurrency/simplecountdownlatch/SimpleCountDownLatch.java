package com.java11.samples.concurrency.simplecountdownlatch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleCountDownLatch {
    private int count;

    ReentrantLock reentrantLock = new ReentrantLock();
    Condition awaitCondition = reentrantLock.newCondition();

    public SimpleCountDownLatch(int count) {
        this.count = count;
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be negative");
        }
    }

    /**
     * Causes the current thread to wait until the latch has counted down to zero.
     * If the current count is already zero then this method returns immediately.
     */
    public void await() throws InterruptedException {
        try {
            reentrantLock.lock();
            while (count > 0) {
                awaitCondition.await();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     *  Decrements the count of the latch, releasing all waiting threads when the count reaches zero.
     *  If the current count already equals zero then nothing happens.
     */
    public void countDown() {
        try {
            reentrantLock.lock();
            count--;
            if (count == 0) {
                awaitCondition.signalAll();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * Returns the current count.
     */
    public int getCount() {
        return count;
    }
}
