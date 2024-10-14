package com.mehedi.javapractice.designpattern.creational.abstractfactory.viewer;

public class PDFViewer implements Viewer {
    @Override
    public void viewDocument() {
        System.out.println("Viewing PDF Document.");
    }
}
