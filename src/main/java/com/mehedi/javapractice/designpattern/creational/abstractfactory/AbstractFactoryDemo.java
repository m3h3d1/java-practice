package com.mehedi.javapractice.designpattern.creational.abstractfactory;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.factory.DocumentFactory;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.factory.OfficeDocumentFactory;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.factory.OpenSourceDocumentFactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // Create Office Document Factory
        DocumentFactory officeFactory = new OfficeDocumentFactory();
        Document officeWord = officeFactory.createWordDocument();
        officeWord.open();
        officeWord.close();

        // Create Open Source Document Factory
        DocumentFactory openSourceFactory = new OpenSourceDocumentFactory();
        Document openSourceWord = openSourceFactory.createWordDocument();
        openSourceWord.open();
        openSourceWord.close();

        // Demonstrate other types of documents
        Document officePDF = officeFactory.createPDFDocument();
        officePDF.open();
        officePDF.close();

        Document openSourcePDF = openSourceFactory.createPDFDocument();
        openSourcePDF.open();
        openSourcePDF.close();
    }
}
