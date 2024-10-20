package com.mehedi.javapractice.designpattern.behavioral.strategy.paymentcomplex.utils;

public class TransactionValidator {
    public static void verify(String identifier, double amount) {
        System.out.println("Verifying transaction for " + identifier + " of amount $" + amount);
        if (amount > 5000) {
            System.out.println("Transaction flagged for manual review.");
        }
    }
}
