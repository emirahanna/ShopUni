package edu.psu.ist.paymentmanagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentIDGenerator {

    private static AtomicLong idCounter = new AtomicLong(fetchMaxIdFromDatabase() + 1);

    public static String createID()
    {
        return String.valueOf(idCounter.getAndIncrement());
    }

    private static long fetchMaxIdFromDatabase() {
        long maxId = 0;
        try (Connection conn = DriverManager.getConnection("jdbc:ucanaccess://src/ProductList.accdb")) {
            String sql = "SELECT MAX(ID) AS MaxID FROM payments";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String maxIdStr = rs.getString("MaxID");
                if (maxIdStr != null && !maxIdStr.isEmpty()) {
                    maxId = Long.parseLong(maxIdStr);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // or log this properly in a real app
        }
        return maxId;
    }
}

