package com.java11.samples.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class ScheduledExecutor {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(() -> {
            System.out.println("Open Zoo");
        }, 0, 1, TimeUnit.MINUTES);

        var result = executorService.submit(() -> System.out.println());
        System.out.println(result.get());

        var value1 = new AtomicLong(0);
        final long value2[] = {0};
        IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> value1.incrementAndGet());

        IntStream.iterate(1, i -> 1).limit(100).parallel().forEach(i -> ++value2[0]);

        System.out.println("value1=" + value1 + " value2=" + value2[0]);
    }

}
