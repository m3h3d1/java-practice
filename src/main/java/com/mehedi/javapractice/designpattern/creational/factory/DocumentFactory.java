package com.mehedi.javapractice.designpattern.creational.factory;

import com.mehedi.javapractice.designpattern.creational.factory.document.Document;
import com.mehedi.javapractice.designpattern.creational.factory.document.PDFDocument;
import com.mehedi.javapractice.designpattern.creational.factory.document.Spreadsheet;
import com.mehedi.javapractice.designpattern.creational.factory.document.WordDocument;

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
