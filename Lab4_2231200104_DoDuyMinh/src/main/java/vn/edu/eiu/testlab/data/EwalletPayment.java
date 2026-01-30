package vn.edu.eiu.testlab.data;

import org.springframework.stereotype.Component;

@Component
public class EwalletPayment implements PaymentMethod {
    private String walletId;
    private String walletProvider;
    private String phoneNumber;

    public EwalletPayment() {
        this.walletId = "DEFAULT001";
        this.walletProvider = "Default Wallet";
        this.phoneNumber = "+00-000-000-000";
    }

    public EwalletPayment(String walletId, String walletProvider, String phoneNumber) {
        this.walletId = walletId;
        this.walletProvider = walletProvider;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean makePayment(double amount) {
        // Simulate eWallet payment processing
        System.out.println("=== Processing eWallet Payment ===");
        System.out.println("Wallet Provider: " + walletProvider);
        System.out.println("Wallet ID: " + walletId);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Amount: $" + String.format("%.2f", amount));
        System.out.println("Payment processed successfully via eWallet!");
        System.out.println("===================================\n");
        return true;
    }
}
