package vn.edu.eiu.testlab.data;

import org.springframework.stereotype.Component;

@Component
public class BankTransferPayment implements PaymentMethod {
    private String accountNumber;
    private String accountHolderName;
    private String bankName;
    private String routingNumber;

    public BankTransferPayment() {
        this.accountNumber = "0000000000";
        this.accountHolderName = "Default Account";
        this.bankName = "Default Bank";
        this.routingNumber = "DEF000";
    }

    public BankTransferPayment(String accountNumber, String accountHolderName, 
                               String bankName, String routingNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.bankName = bankName;
        this.routingNumber = routingNumber;
    }

    @Override
    public boolean makePayment(double amount) {
        // Simulate bank transfer payment processing
        System.out.println("=== Processing Bank Transfer ===");
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: *****" + accountNumber.substring(accountNumber.length() - 4));
        System.out.println("Routing Number: " + routingNumber);
        System.out.println("Amount: $" + String.format("%.2f", amount));
        System.out.println("Payment processed successfully via Bank Transfer!");
        System.out.println("================================\n");
        return true;
    }
}
