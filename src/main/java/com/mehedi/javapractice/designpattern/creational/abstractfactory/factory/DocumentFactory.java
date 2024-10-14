package com.mehedi.javapractice.designpattern.creational.abstractfactory.factory;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;

public interface DocumentFactory {
    Document createWordDocument();
    Document createPDFDocument();
    Document createSpreadsheet();
}
