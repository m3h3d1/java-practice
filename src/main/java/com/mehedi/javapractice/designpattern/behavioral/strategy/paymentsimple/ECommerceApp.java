package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentsimple;

import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentsimple.strategies.PayByBank;
import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentsimple.strategies.PayByCreditCard;
import com.mehedi.javapractice.designpattern.behavioral.strategy.paymentsimple.strategies.PayByPayPal;

public class ECommerceApp {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new PayByCreditCard("1234-5678-9101", "John Willis", "123"));
        context.checkout(250.75);  // Output: Processing credit card payment of $250.75

        context.setPaymentStrategy(new PayByPayPal("user@example.com"));
        context.checkout(150.25);  // Output: Processing PayPal payment of $150.25

        context.setPaymentStrategy(new PayByBank("987654321"));
        context.checkout(500.00);  // Output: Processing bank transfer of $500.00
    }
}
