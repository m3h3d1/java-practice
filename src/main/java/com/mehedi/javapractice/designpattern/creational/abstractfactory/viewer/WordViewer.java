package com.mehedi.javapractice.designpattern.creational.abstractfactory.viewer;

public class WordViewer implements Viewer {
    @Override
    public void viewDocument() {
        System.out.println("Viewing Word Document.");
    }
}
