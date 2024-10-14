package com.mehedi.javapractice.designpattern.creational.abstractfactory.document.office;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;

public class OfficeWordDocument implements Document {
    public void open() {
        System.out.println("Opening Office Word Document.");
    }

    public void close() {
        System.out.println("Closing Office Word Document.");
    }
}
