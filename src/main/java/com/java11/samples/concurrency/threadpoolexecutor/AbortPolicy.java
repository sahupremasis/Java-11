package com.java11.samples.concurrency.threadpoolexecutor;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import static java.lang.Process.*;

public class AbortPolicy {

    public static void main(String [] args) {
        System.out.println("Test");


        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS,
                                                             new SynchronousQueue<>(),
                                                             new ThreadPoolExecutor.AbortPolicy());


        int r = Runtime.getRuntime().availableProcessors();
        System.out.println(r);

    }

}
