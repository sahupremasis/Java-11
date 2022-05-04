package com.java11.samples.concurrency.simplecountdownlatch;

import java.util.concurrent.Executors;

public class SimpleCountDownLatchTesting {

    public static void main(String[] args) {

        SimpleCountDownLatch simpleCountDownLatch = new SimpleCountDownLatch(10);

        Executors.newFixedThreadPool(10);
        System.out.println("CountDownLatch has been created with count=3");


    }

    private class MyRunnable implements Runnable {
        SimpleCountDownLatch countDownLatchCustom;

        MyRunnable(SimpleCountDownLatch countDownLatchCustom) {
            this.countDownLatchCustom = countDownLatchCustom;
        }

        public void run() {
            for(int i = 2; i >= 0; i--) {
                countDownLatchCustom.countDown();
                System.out.println(Thread.currentThread().getName() +
                                           " has reduced latch count to : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
