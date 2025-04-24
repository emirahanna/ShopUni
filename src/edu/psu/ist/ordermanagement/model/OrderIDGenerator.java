package edu.psu.ist.ordermanagement.model;

import java.util.concurrent.atomic.AtomicLong;

public class OrderIDGenerator {
    private static AtomicLong idCounter = new AtomicLong();

    public static String createID()
    {
        return String.valueOf(idCounter.getAndIncrement());
    }
}
