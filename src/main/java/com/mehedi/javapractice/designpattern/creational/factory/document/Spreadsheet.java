package com.mehedi.javapractice.designpattern.creational.factory.document;

public class Spreadsheet implements Document {
    @Override
    public void open() {
        System.out.println("Opening Spreadsheet Document.");
    }

    @Override
    public void close() {
        System.out.println("Closing Spreadsheet Document.");
    }
}
