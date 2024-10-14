package com.mehedi.javapractice.designpattern.creational.factorymethod.factory;

import com.mehedi.javapractice.designpattern.creational.factorymethod.document.Document;
import com.mehedi.javapractice.designpattern.creational.factorymethod.document.Spreadsheet;

public class SpreadsheetFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new Spreadsheet();
    }
}
