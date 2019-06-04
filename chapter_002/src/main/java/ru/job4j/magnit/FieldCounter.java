package ru.job4j.magnit;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FieldCounter extends DefaultHandler {
    private long sum;

    @Override
    public void startDocument() throws SAXException {
        System.out.println(" Start Documents");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("XML parsing ended.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element" + qName);
        if (qName.equals("entry")) {
            sum += Integer.valueOf(attributes.getValue("field"));
        }
    }

    public long getSum() {
        return sum;
    }
}
