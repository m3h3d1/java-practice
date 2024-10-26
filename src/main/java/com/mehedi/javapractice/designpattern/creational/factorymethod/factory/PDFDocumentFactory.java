package com.mehedi.javapractice.designpattern.creational.factorymethod.factory;

import com.mehedi.javapractice.designpattern.creational.factorymethod.document.Document;
import com.mehedi.javapractice.designpattern.creational.factorymethod.document.PDFDocument;

public class PDFDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
}
