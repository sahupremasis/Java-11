package com.java11.samples;

import java.util.stream.IntStream;

public class HelloJava11 {

    public static void main(String [] args) {
        System.out.println("Hello World!");

        double db = IntStream.range(1, 5).average().getAsDouble();
        System.out.println("average is: " + db);
    }

}
