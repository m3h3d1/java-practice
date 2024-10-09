package com.mehedi.javapractice.designpattern.creational.singleton;

public class BillPughSingleton {
    private BillPughSingleton() {
        if(SingletonHolder.INSTANCE != null) {
            throw new RuntimeException("Instance already created, use getInstance()");
        }
    }
    private static class SingletonHolder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
