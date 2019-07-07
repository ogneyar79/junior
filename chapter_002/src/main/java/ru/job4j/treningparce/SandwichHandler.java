package ru.job4j.treningparce;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SandwichHandler extends DefaultHandler {

    private Sandwich sandwich;
    private String currentQName;
    private int countIngridients;

    public SandwichHandler() {
        sandwich = new Sandwich();
    }

    public Sandwich getSandwich() {
        new SandwichHandler();
        return sandwich;
    }

    public void startDocument() throws SAXException {
        System.out.println(" Start Documents");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element : " + qName);
        currentQName = qName;
        countIngridients = (attributes.getLength() > 0) ? Integer.parseInt(attributes.getValue(0)) : 1;

        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("Atribute : " + attributes.getQName(i) + " " + attributes.getValue(i));
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        System.out.println(" Characters:  " + value);

        switch (currentQName) {
            case "title":
                sandwich.setTitle(value);
                break;
            case "ingridient":
                for (int i = 0; i < countIngridients; i++) {
                    sandwich.addIngridient(new Ingridient(value));
                }
            default:
                throw new RuntimeException("unreachable");

        }

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(" End element: " + qName);
        currentQName = "";
    }

    public void endDocument() throws SAXException {
        System.out.println(" End document");
    }


}
