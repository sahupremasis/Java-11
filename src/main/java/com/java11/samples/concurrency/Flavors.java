package com.java11.samples.concurrency;

import java.util.stream.LongStream;

public class Flavors {

    public static int counter;

    public static void countIcecreamFlavors() {
        counter = 0;

        Runnable task = () -> {

            try {
                Thread.sleep(10);
                System.out.println(counter++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        LongStream.range(1, 500).forEach(m -> new Thread(task).run());
        System.out.println("counter: " + counter);
    }

    public static void main(String[] args) {
        Flavors flavors = new Flavors();
        flavors.countIcecreamFlavors();
    }

}
