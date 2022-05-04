package com.java11.samples;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Sample {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 4);
        UnaryOperator<Long> operator = s -> s * s * s;
        list.forEach(System.out::println);
    }
}

