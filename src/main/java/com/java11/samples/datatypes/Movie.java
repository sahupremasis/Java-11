package com.java11.samples.datatypes;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

interface Temp {

}

public class Movie {

    private int butter = 5;

    private Movie() {
    }

    public static void main(String[] args) {
        var movie = new Movie();
        Movie.Popcorn in = new Movie().new Popcorn();
        in.startMovie();
    }

    private class Camel {

    }

    protected class Popcorn {
        public static final int butter = 10;
        Consumer<Camel> camelConsumer = (final Camel c) -> {
        };
        BiConsumer<String, Integer> biConsumer = (i, j) -> {
        };
        private Popcorn() {
        }

        public void startMovie() {
            System.out.println(butter);
        }
    }

}
