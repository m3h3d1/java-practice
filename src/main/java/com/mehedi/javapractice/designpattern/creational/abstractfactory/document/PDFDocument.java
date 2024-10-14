package com.mehedi.javapractice.designpattern.creational.abstractfactory.document;

public class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document.");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Document.");
    }
}
