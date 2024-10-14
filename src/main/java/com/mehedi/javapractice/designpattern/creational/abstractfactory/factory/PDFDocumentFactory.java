package com.mehedi.javapractice.designpattern.creational.abstractfactory.factory;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.PDFDocument;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.viewer.PDFViewer;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.viewer.Viewer;

public class PDFDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }

    @Override
    public Viewer createViewer() {
        return new PDFViewer();
    }
}
