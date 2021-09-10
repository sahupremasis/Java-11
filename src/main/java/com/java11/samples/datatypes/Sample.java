package com.java11.samples.datatypes;
import com.java11.samples.concurrency.Flavors;

import java.lang.annotation.Documented;

public class Sample {

    private int temp = 5;

    protected static class AnotherSample {
        private static int temp = 10;
    }

    enum Flavors {
        VANILLA, CHOCOLATE, STRAWBERRY;
        static final Flavors DEFAULT = STRAWBERRY;
    }

    static long addCandy(double fruit, float vegetables) {
        return -1;
    }

    public static void main(String [] args) {
        for(var e : Flavors.values()) {
            System.out.println(e.ordinal());
        }

        var sample = new Sample();
        Sample.AnotherSample anotherSample = new AnotherSample();


    }

}
