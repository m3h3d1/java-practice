package com.mehedi.javapractice.designpattern.creational.factorymethod.factory;

import com.mehedi.javapractice.designpattern.creational.factorymethod.document.Document;
import com.mehedi.javapractice.designpattern.creational.factorymethod.document.WordDocument;

public class WordDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
