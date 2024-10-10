package com.mehedi.javapractice.designpattern.creational.factory;

public class DocumentFactory {
    public Document getDocument(String documentType) {
        if (documentType == null) return null;
        return switch (documentType) {
            case "WORD" -> new WordDocument();
            case "PDF" -> new PDFDocument();
            case "SPREADSHEET" -> new Spreadsheet();
            default -> null;
        };
    }
}
