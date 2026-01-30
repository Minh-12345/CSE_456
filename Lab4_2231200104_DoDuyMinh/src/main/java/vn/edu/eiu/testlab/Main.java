package vn.edu.eiu.testlab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vn.edu.eiu.testlab.data.BankTransferPayment;
import vn.edu.eiu.testlab.data.CardPayment;
import vn.edu.eiu.testlab.data.EwalletPayment;
import vn.edu.eiu.testlab.data.PaymentMethod;
import vn.edu.eiu.testlab.service.PaymentService;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo Spring container
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        
        IO.println("=================================================");
        IO.println("  Payment Processing System - Lab 04");
        IO.println("  Spring IoC & Dependency Injection");
        IO.println("=================================================\n");

        double paymentAmount = 150.75;

        // Demo 1: Card Payment
        IO.println("--- DEMO 1: Card Payment ---\n");
        PaymentMethod cardPayment = appContext.getBean(CardPayment.class);
        PaymentService cardPaymentService = new PaymentService(cardPayment);
        IO.println(cardPaymentService.getPaymentMethodInfo());
        cardPaymentService.processPayment(paymentAmount);

        // Demo 2: eWallet Payment
        IO.println("--- DEMO 2: eWallet Payment ---\n");
        PaymentMethod ewalletPayment = appContext.getBean(EwalletPayment.class);
        PaymentService ewalletPaymentService = new PaymentService(ewalletPayment);
        IO.println(ewalletPaymentService.getPaymentMethodInfo());
        ewalletPaymentService.processPayment(paymentAmount);

        // Demo 3: Bank Transfer
        IO.println("--- DEMO 3: Bank Transfer ---\n");
        PaymentMethod bankTransferPayment = appContext.getBean(BankTransferPayment.class);
        PaymentService bankTransferService = new PaymentService(bankTransferPayment);
        IO.println(bankTransferService.getPaymentMethodInfo());
        bankTransferService.processPayment(paymentAmount);

        // Demo 4: Thử nhiều payment method
        IO.println("--- DEMO 4: Multiple Payment Methods ---\n");
        
        PaymentMethod[] paymentMethods = {
            appContext.getBean(CardPayment.class),
            appContext.getBean(EwalletPayment.class),
            appContext.getBean(BankTransferPayment.class)
        };
        
        for (PaymentMethod method : paymentMethods) {
            PaymentService service = new PaymentService(method);
            service.processPayment(50.00);
        }

        // Demo 5: Lấy PaymentService từ Spring
        IO.println("--- DEMO 5: PaymentService Bean ---\n");
        PaymentService springManagedService = appContext.getBean(PaymentService.class);
        springManagedService.setPaymentMethod(appContext.getBean(CardPayment.class));
        springManagedService.processPayment(99.99);

        IO.println("=================================================");
        IO.println("  Demo hoàn thành!");
        IO.println("=================================================");
        
        ((AnnotationConfigApplicationContext) appContext).close();
    }
}
