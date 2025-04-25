package edu.psu.ist.usermanagement.model;

import java.util.concurrent.atomic.AtomicLong;

public class UserIDGenerator {
    private static AtomicLong idCounter = new AtomicLong();

    public static String createID()
    {
        return String.valueOf(idCounter.getAndIncrement());
    }
}
