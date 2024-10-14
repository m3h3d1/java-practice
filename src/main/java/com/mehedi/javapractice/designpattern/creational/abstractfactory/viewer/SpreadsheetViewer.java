package com.mehedi.javapractice.designpattern.creational.abstractfactory.viewer;

public class SpreadsheetViewer implements Viewer {
    @Override
    public void viewDocument() {
        System.out.println("Viewing Spreadsheet Document.");
    }
}
