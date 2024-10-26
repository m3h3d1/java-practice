package com.mehedi.javapractice.designpattern.creational.abstractfactory.document.office;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;

public class OfficeSpreadsheet implements Document {
    public void open() {
        System.out.println("Opening Office Spreadsheet Document.");
    }

    public void close() {
        System.out.println("Closing Office Spreadsheet Document.");
    }
}
