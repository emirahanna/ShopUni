package model.OrderManagement;
import model.PaymentManagement.Payment;

enum DeliveryOption{PICKUP, DELIVERY}

public class Order {
    private Payment payment;
    private double orderTotal;
    private String orderID;
    private String address;
    private DeliveryOption deliveryOption;


}
