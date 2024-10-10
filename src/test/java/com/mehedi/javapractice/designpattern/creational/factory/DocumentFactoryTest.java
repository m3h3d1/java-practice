package com.mehedi.javapractice.designpattern.creational.factory;

import org.junit.jupiter.api.Test;

public class DocumentFactoryTest {

    @Test
    void testGetDocument_Word() {
        DocumentFactory documentFactory = new DocumentFactory();
        Document document = documentFactory.getDocument("WORD");
        assert(document != null);
        assert(document instanceof WordDocument);
    }

    @Test
    void testGetDocument_PDF() {
        DocumentFactory documentFactory = new DocumentFactory();
        Document document = documentFactory.getDocument("PDF");
        assert(document != null);
        assert(document instanceof PDFDocument);
    }

    @Test
    void testGetDocument_Spreadsheet() {
        DocumentFactory documentFactory = new DocumentFactory();
        Document document = documentFactory.getDocument("SPREADSHEET");
        assert(document != null);
        assert(document instanceof Spreadsheet);
    }

    @Test
    void testGetDocument_NonExistent() {
        DocumentFactory documentFactory = new DocumentFactory();
        Document document = documentFactory.getDocument("PRESENTATION");
        assert(document == null);
    }
}
