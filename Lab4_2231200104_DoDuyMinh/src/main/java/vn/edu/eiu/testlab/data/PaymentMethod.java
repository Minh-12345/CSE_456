package vn.edu.eiu.testlab.data;

/**
 * Interface cho các phương thức thanh toán
 */
public interface PaymentMethod {
    boolean makePayment(double amount);
}
