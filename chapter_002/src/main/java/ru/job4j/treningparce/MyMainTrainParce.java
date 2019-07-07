package ru.job4j.treningparce;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class MyMainTrainParce {


    public static void main(String... args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        File file = new File("C:\\projects\\sirotkinmaksim\\chapter_002\\src"
                +
                "\\main\\resources\\country.xml");

        if (file.exists()) {
            parser.parse(file, new MyHandler());
        }

    }
}
