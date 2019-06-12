package ru.job4j.treningparce;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {

    public void startDocument() throws SAXException {
        System.out.println(" Start Documents");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element : " + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("Atribute : " + attributes.getQName(i) + " " + attributes.getValue(i));
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(" Characters:  " + new String(ch, start, length));
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(" End element: " + qName);
    }

    public void endDocument() throws SAXException {
        System.out.println(" End document");
    }


}
