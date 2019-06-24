package ru.job4j.magnit;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ParserCountSumBySax {

    File file;

    public Long parseCountSumFromXmlBySax(File file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        HandlerSumer handlerSumer = new HandlerSumer();
        if (file.exists()) {
            parser.parse(file, handlerSumer);

        }
        return handlerSumer.getSum();
    }

    private class HandlerSumer extends DefaultHandler {

        Long sum = 0L;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println(String.format("Start element is %s", qName));
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(String.format("Atribute is %s Value is %s", attributes.getQName(i), attributes.getValue(i)));
                sum += Integer.valueOf(attributes.getValue(i));
                System.out.println(String.format(" Sum for %s itaration is %d ", i, sum));
            }
        }

        public Long getSum() {
            return sum;
        }

    }
}
