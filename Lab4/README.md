# LAB 04 - Payment Processing System

## Student Information
- **Student's Full Name:** [Your Name]
- **Student ID:** [Your Student ID]
- **Course:** CSE 456 - Advanced Java Programming
- **Quarter:** 4, 2024-2025

---

## Tổng quan

Hệ thống xử lý thanh toán sử dụng Spring Framework để demo các nguyên lý:
- Spring IoC/DI
- Open-Closed Principle
- Single Responsibility Principle 
- Kiến trúc 3 lớp

## Công nghệ
- Java 25
- Spring Framework 7.0.3
- Maven

## Cấu trúc

### 1. Presentation Layer (Main.java)
Khởi tạo Spring container và gọi các service để xử lý thanh toán.

### 2. Service Layer (PaymentService.java) 
Xử lý business logic, dùng `@Service` annotation.
Nhận PaymentMethod qua constructor injection.

### 3. Data Layer (package data)
**Interface PaymentMethod:**
- Method: `boolean makePayment(double amount)`

**Các implementation:**
- CardPayment - thanh toán thẻ
- EwalletPayment - ví điện tử  
- BankTransferPayment - chuyển khoản

Mỗi class có `@Component` để Spring quản lý.

### 4. Config (AppConfig.java)
Dùng `@Configuration` và `@ComponentScan` để config Spring.

---

## Các nguyên lý đã áp dụng

### Spring IoC Container
```java
ApplicationContext appContext = 
    new AnnotationConfigApplicationContext(AppConfig.class);
PaymentMethod cardPayment = appContext.getBean(CardPayment.class);
```

### Dependency Injection
```java
@Service
public class PaymentService {
    private PaymentMethod paymentMethod;
    
    @Autowired
    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
```

### Open-Closed Principle
Có thể thêm payment method mới không cần sửa code cũ.

### Single Responsibility Principle  
Mỗi class chỉ làm 1 việc:
- PaymentService: xử lý payment
- CardPayment: xử lý thẻ
- Main: hiển thị UI

---

## Cách chạy

### Maven
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="vn.edu.eiu.testlab.Main"
```

### IntelliJ IDEA
1. Mở project
2. Chạy Main class

---

## Kết luận

Project demo các khái niệm:
- Spring IoC/DI
- OCP, SRP
- 3-layer architecture
- Strategy pattern

---

## Author
[Your Name] - EIU
