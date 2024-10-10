package com.mehedi.javapractice.designpattern.creational.factorymethod;

public interface DocumentFactory {
    Document createDocument();
}

class WordDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PDFDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
}

class SpreadsheetFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new Spreadsheet();
    }
}
