package com.mehedi.javapractice.designpattern.creational.abstractfactory.factory;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.opensource.OpenSourcePDFDocument;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.opensource.OpenSourceSpreadsheet;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.opensource.OpenSourceWordDocument;

public class OpenSourceDocumentFactory implements DocumentFactory {
    @Override
    public Document createWordDocument() {
        return new OpenSourceWordDocument();
    }

    @Override
    public Document createPDFDocument() {
        return new OpenSourcePDFDocument();
    }

    @Override
    public Document createSpreadsheet() {
        return new OpenSourceSpreadsheet();
    }
}
