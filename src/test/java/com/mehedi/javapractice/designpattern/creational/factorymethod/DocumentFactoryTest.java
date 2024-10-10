package com.mehedi.javapractice.designpattern.creational.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentFactoryTest {

    @Test
    void testCreateDocument_Word() {
        DocumentFactory documentFactory = new WordDocumentFactory();
        Document document = documentFactory.createDocument();
        assertTrue((document instanceof WordDocument));
    }

    @Test
    void testCreateDocument_PDF() {
        DocumentFactory documentFactory = new PDFDocumentFactory();
        Document document = documentFactory.createDocument();
        assertTrue(document instanceof PDFDocument);
    }

    @Test
    void testCreateDocument_Spreadsheet() {
        DocumentFactory documentFactory = new SpreadsheetFactory();
        Document document = documentFactory.createDocument();
        assertTrue(document instanceof Spreadsheet);
    }
}
