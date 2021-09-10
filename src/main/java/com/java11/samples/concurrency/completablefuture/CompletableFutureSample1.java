package com.java11.samples.concurrency.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureSample1 {

    public static void main(String [] args) {
        CompletableFutureSample1 sample1 = new CompletableFutureSample1();
        sample1.startCompletableFuture();
    }

    private void startCompletableFuture() {

        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));

        CompletableFuture<String> cf = CompletableFuture.completedFuture("message").thenApply(s -> {
            System.out.println(Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        System.out.println(cf.getNow(null));
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
