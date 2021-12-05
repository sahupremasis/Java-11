package com.java11.samples;

import java.awt.print.Printable;
import java.io.Console;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Random;

interface Operator {
    int operate(int i, int j);
}

public class Test {


    public static void main(String [] args) {


    }

    private interface Printable {
        public void print(int msg);
    }
}
