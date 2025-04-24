package edu.psu.ist.paymentmanagement.model;

import java.util.concurrent.atomic.AtomicLong;

public class PaymentIDGenerator {
    private static AtomicLong idCounter = new AtomicLong();

    public static String createID()
    {
        return String.valueOf(idCounter.getAndIncrement());
    }
}
