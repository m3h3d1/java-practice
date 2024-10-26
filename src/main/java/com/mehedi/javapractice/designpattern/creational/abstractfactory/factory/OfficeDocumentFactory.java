package com.mehedi.javapractice.designpattern.creational.abstractfactory.factory;

import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.Document;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.office.OfficePDFDocument;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.office.OfficeSpreadsheet;
import com.mehedi.javapractice.designpattern.creational.abstractfactory.document.office.OfficeWordDocument;

public class OfficeDocumentFactory implements DocumentFactory {
    @Override
    public Document createWordDocument() {
        return new OfficeWordDocument();
    }

    @Override
    public Document createPDFDocument() {
        return new OfficePDFDocument();
    }

    @Override
    public Document createSpreadsheet() {
        return new OfficeSpreadsheet();
    }
}
