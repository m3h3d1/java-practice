package com.mehedi.javapractice.designpattern.creational.abstractfactory.factory;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.SpreadsheetDocument;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.viewer.SpreadsheetViewer;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.viewer.Viewer;

public class SpreadsheetDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new SpreadsheetDocument();
    }

    @Override
    public Viewer createViewer() {
        return new SpreadsheetViewer();
    }
}
