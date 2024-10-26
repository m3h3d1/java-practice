package com.mehedi.javapractice.designpattern.creational.abstractfactory;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.factory.DocumentFactory;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.factory.OfficeDocumentFactory;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.factory.OpenSourceDocumentFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractFactoryDemoTest {
    @Test
    public void testOfficeDocumentFactory() {
        DocumentFactory officeFactory = new OfficeDocumentFactory();

        Document officeWord = officeFactory.createWordDocument();
        assertNotNull(officeWord);
        assertTrue(officeWord instanceof Document);
        officeWord.open();  // print: Opening Office Word Document.
        officeWord.close(); // print: Closing Office Word Document.

        Document officePDF = officeFactory.createPDFDocument();
        assertNotNull(officePDF);
        assertTrue(officePDF instanceof Document);
        officePDF.open();  // print: Opening Office PDF Document.
        officePDF.close(); // print: Closing Office PDF Document.

        Document officeSpreadsheet = officeFactory.createSpreadsheet();
        assertNotNull(officeSpreadsheet);
        assertTrue(officeSpreadsheet instanceof Document);
        officeSpreadsheet.open();  // print: Opening Office Spreadsheet Document.
        officeSpreadsheet.close(); // print: Closing Office Spreadsheet Document.
    }

    @Test
    public void testOpenSourceDocumentFactory() {
        DocumentFactory openSourceFactory = new OpenSourceDocumentFactory();

        Document openSourceWord = openSourceFactory.createWordDocument();
        assertNotNull(openSourceWord);
        assertTrue(openSourceWord instanceof Document);
        openSourceWord.open();  // print: Opening Open Source Word Document.
        openSourceWord.close(); // print: Closing Open Source Word Document.

        Document openSourcePDF = openSourceFactory.createPDFDocument();
        assertNotNull(openSourcePDF);
        assertTrue(openSourcePDF instanceof Document);
        openSourcePDF.open();  // print: Opening Open Source PDF Document.
        openSourcePDF.close(); // print: Closing Open Source PDF Document.

        Document openSourceSpreadsheet = openSourceFactory.createSpreadsheet();
        assertNotNull(openSourceSpreadsheet);
        assertTrue(openSourceSpreadsheet instanceof Document);
        openSourceSpreadsheet.open();  // print: Opening Open Source Spreadsheet Document.
        openSourceSpreadsheet.close(); // print: Closing Open Source Spreadsheet Document.
    }
}
