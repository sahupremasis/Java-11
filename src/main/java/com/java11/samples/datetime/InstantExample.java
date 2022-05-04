package com.java11.samples.datetime;

import java.time.*;
import java.util.Date;

public class InstantExample {

    public static void main(String[] args) throws InterruptedException {
        Instant first = Instant.now();


        Thread.sleep(2000);
        Instant second = Instant.now();
        Duration duration = Duration.between(first, second);
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(second.getNano());
        System.out.println(second.getEpochSecond());

        Instant instant = Instant.now();
        ZonedDateTime singaporeZonedDateTime = instant.atZone(ZoneId.ofOffset("GMT", ZoneOffset.ofHours(8)));
        System.out.println("instant: " + instant);
        System.out.println("singaporeZonedDateTime " + singaporeZonedDateTime);

        Date date = new Date();
        long sec = date.toInstant().toEpochMilli();
        System.out.println(sec);
        System.out.println(System.currentTimeMillis());
    }


}
