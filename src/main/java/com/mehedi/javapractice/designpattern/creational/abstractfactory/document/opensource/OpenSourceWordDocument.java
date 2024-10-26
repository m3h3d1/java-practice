package com.mehedi.javapractice.designpattern.creational.abstractfactory.document.opensource;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;

public class OpenSourceWordDocument implements Document {
    public void open() {
        System.out.println("Opening Open Source Word Document.");
    }

    public void close() {
        System.out.println("Closing Open Source Word Document.");
    }
}
