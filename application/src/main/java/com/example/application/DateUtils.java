package com.example.application;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String dateToString(long productCreationDate) {
        Instant createdAt = Instant.ofEpochMilli(productCreationDate);
        return DateTimeFormatter.ISO_INSTANT.format(createdAt);
    }
}
