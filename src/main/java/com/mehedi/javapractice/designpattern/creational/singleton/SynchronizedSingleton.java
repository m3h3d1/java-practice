package com.mehedi.javapractice.designpattern.creational.singleton;

public class SynchronizedSingleton {

    // Static instance variable
    private static SynchronizedSingleton instance;

    // Private constructor to prevent instantiation
    private SynchronizedSingleton() {}

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }

    public String showMessage() {
        return "Thread-Safe Singleton Instance";
    }

    public static void main(String[] args) {
        SynchronizedSingleton instance = SynchronizedSingleton.getInstance();
        System.out.println(instance.showMessage());
    }
}
