package com.mehedi.javapractice.designpattern.creational.abstractfactory.document;

public class SpreadsheetDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Spreadsheet Document.");
    }

    @Override
    public void close() {
        System.out.println("Closing Spreadsheet Document.");
    }
}
