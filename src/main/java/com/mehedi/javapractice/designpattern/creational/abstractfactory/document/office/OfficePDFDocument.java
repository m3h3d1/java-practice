package com.mehedi.javapractice.designpattern.creational.abstractfactory.document.office;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;

public class OfficePDFDocument implements Document {
    public void open() {
        System.out.println("Opening Office PDF Document.");
    }

    public void close() {
        System.out.println("Closing Office PDF Document.");
    }
}
