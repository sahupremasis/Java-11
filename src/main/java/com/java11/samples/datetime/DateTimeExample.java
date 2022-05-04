package com.java11.samples.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class DateTimeExample {

    public static void main(String[] args) {
        boolean tomorrow = LocalDate.now().minus(2, ChronoUnit.DAYS).isLeapYear();
        System.out.println(tomorrow);

        ZoneId zoneId = ZoneId.of("Europe/Paris");

        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();

        allZoneIds.forEach(System.out::println);
        LocalDateTime.ofEpochSecond(1, 1, ZoneOffset.MAX);

    }

}
