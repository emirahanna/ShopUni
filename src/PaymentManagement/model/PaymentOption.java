package PaymentManagement.model;

public class PaymentOption{
    public sealed interface Option {}
    public record Card () implements  Option{}
    public record Cash() implements  Option{}
    public record GiftCard() implements Option{}
}

