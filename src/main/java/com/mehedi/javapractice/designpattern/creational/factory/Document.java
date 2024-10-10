package com.mehedi.javapractice.designpattern.creational.factory;

public interface Document {
    void open();
    void close();
}

class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("Opening Word Document.");
    }

    @Override
    public void close() {
        System.out.println("Closing Word Document.");
    }
}

class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document.");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF Document.");
    }
}

class Spreadsheet implements Document {
    @Override
    public void open() {
        System.out.println("Opening Spreadsheet Document.");
    }

    @Override
    public void close() {
        System.out.println("Closing Spreadsheet Document.");
    }
}
