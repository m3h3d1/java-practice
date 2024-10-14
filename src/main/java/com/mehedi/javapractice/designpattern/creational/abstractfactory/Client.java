package com.mehedi.javapractice.designpattern.creational.abstractfactory;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.factory.DocumentFactory;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.factory.PDFDocumentFactory;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.factory.SpreadsheetDocumentFactory;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.factory.WordDocumentFactory;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.viewer.Viewer;

public class Client {
    private final Document document;
    private final Viewer viewer;

    public Client(DocumentFactory factory) {
        document = factory.createDocument();
        viewer = factory.createViewer();
    }

    public void run() {
        document.open();
        viewer.viewDocument();
        document.close();
    }

    public static void main(String[] args) {
        // Using Word factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        Client wordClient = new Client(wordFactory);
        wordClient.run();

        // Using PDF factory
        DocumentFactory pdfFactory = new PDFDocumentFactory();
        Client pdfClient = new Client(pdfFactory);
        pdfClient.run();

        // Using Spreadsheet factory
        DocumentFactory spreadsheetFactory = new SpreadsheetDocumentFactory();
        Client spreadsheetClient = new Client(spreadsheetFactory);
        spreadsheetClient.run();
    }
}
