package com.java11.samples.concurrency.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureSample1 {

    public static void main(String[] args) throws Exception {
        CompletableFutureSample1 sample1 = new CompletableFutureSample1();
        sample1.startCompletableFuture();
    }

    private void startCompletableFuture() {

        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                         new Shop("LetsSaveBig"),
                                         new Shop("MyFavoriteShop"),
                                         new Shop("BuyItAll"));

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Sleeping in cf1");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Exception in cf1 function");
                e.printStackTrace();
            }
            System.out.println("returning cf1");
            return "cf1";
        });
        CompletableFuture<String> cf2 = cf1.thenApply((s) -> {
            System.out.println("applying String in cf2: " + s);
            try {
                Thread.sleep(3000);
                throw new RuntimeException("Runtime exception in cf2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s + "cf2";
        });

        cf2.exceptionally((t) -> {
            System.out.println("Throwable in cf2 is: " + t);
            return "Exception cf2";
        });
//        cf1.complete("Nothing");

//        String cf1Str = cf1.join();
//        String cf2Str = cf2.join();
//        System.out.println("cf1Str is: " + cf1Str);
//        System.out.println("cf2Str is: " + cf2Str);
        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            System.out.println(Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        System.out.println("cf.getNow is " + cf.getNow(null));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("cf1.isDone() is " + cf1.isDone());
        System.out.println("cf2.isDone() is " + cf2.isDone());
        System.out.println(" cf1.join() is " + cf1.join());
        System.out.println(" cf2.join() is " + cf2.join());
    }

    private class Shop {
        private String name = "";

        public Shop(String str) {
            this.name = str;
        }

        private String getName() {
            return name;
        }
    }

}
