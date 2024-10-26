package com.mehedi.javapractice.designpattern.creational.abstractfactory.document.opensource;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;

public class OpenSourceSpreadsheet implements Document {
    public void open() {
        System.out.println("Opening Open Source Spreadsheet Document.");
    }

    public void close() {
        System.out.println("Closing Open Source Spreadsheet Document.");
    }
}
