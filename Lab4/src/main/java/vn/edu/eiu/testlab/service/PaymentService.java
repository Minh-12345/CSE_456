package vn.edu.eiu.testlab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.eiu.testlab.data.PaymentMethod;

@Service
public class PaymentService {
    private PaymentMethod paymentMethod;

    @Autowired(required = false)
    public PaymentService(PaymentMethod paymentMethod) {
        if (paymentMethod != null) {
            this.paymentMethod = paymentMethod;
        }
    }
    
    public PaymentService() {
    }
    
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Payment amount must be greater than zero.");
            return false;
        }

        System.out.println("PaymentService: Initiating payment processing...");
        boolean result = paymentMethod.makePayment(amount);
        
        if (result) {
            System.out.println("PaymentService: Payment completed successfully.\n");
        } else {
            System.out.println("PaymentService: Payment failed.\n");
        }
        
        return result;
    }

    public String getPaymentMethodInfo() {
        return "Current payment method: " + paymentMethod.getClass().getSimpleName();
    }
}
