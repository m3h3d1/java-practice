package com.mehedi.javapractice.designpattern.creational.abstractfactory.factory;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.WordDocument;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.viewer.Viewer;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.viewer.WordViewer;

public class WordDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }

    @Override
    public Viewer createViewer() {
        return new WordViewer();
    }
}
