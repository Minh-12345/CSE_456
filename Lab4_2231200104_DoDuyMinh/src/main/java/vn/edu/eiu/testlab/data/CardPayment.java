package vn.edu.eiu.testlab.data;

import org.springframework.stereotype.Component;

@Component
public class CardPayment implements PaymentMethod {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    // Constructor mặc định cho Spring
    public CardPayment() {
        this.cardNumber = "0000000000000000";
        this.cardHolderName = "Default User";
        this.expiryDate = "12/99";
        this.cvv = "000";
    }

    public CardPayment(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean makePayment(double amount) {
        // Simulate card payment processing
        System.out.println("=== Processing Card Payment ===");
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Number: **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Amount: $" + String.format("%.2f", amount));
        System.out.println("Payment processed successfully via Credit/Debit Card!");
        System.out.println("================================\n");
        return true;
    }
}
