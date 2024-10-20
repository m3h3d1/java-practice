package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex;

import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.discount.PercentageDiscount;
import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.strategies.FailoverPayment;
import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.strategies.PayByCreditCard;
import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.strategies.PayByPayPal;
import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.strategies.PaymentStrategy;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        // Set a percentage discount strategy
        processor.setDiscountStrategy(new PercentageDiscount(10));

        // Primary strategy: Credit Card, fallback strategy: PayPal
        PaymentStrategy primaryStrategy = new PayByCreditCard("1234-5678-9012", "John Doe", "123");
        PaymentStrategy fallbackStrategy = new PayByPayPal("user@example.com");
        PaymentStrategy failoverStrategy = new FailoverPayment(primaryStrategy, fallbackStrategy);

        // Set the failover strategy in the payment processor
        processor.setPaymentStrategy(failoverStrategy);

        // Process payment asynchronously
        CompletableFuture<Boolean> result = processor.checkout(200, "EUR");

        // Wait for completion
        result.thenAccept(success -> {
            if (success) {
                System.out.println("Payment completed successfully.");
            } else {
                System.out.println("Payment failed.");
            }
        }).join(); // Blocking wait for asynchronous result
    }
}
