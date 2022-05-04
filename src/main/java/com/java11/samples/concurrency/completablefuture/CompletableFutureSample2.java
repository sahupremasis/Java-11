package com.java11.samples.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSample2 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        CompletableFutureSample2 sample2 = new CompletableFutureSample2();
        try {
            sample2.simpleGetCall();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void simpleGetCall() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        boolean complete = completableFuture.complete("Future's Result");
        System.out.println("complete: " + complete);
        System.out.println(completableFuture.get());
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Hello World!!";
        });
        System.out.println(future.get());
    }

}
