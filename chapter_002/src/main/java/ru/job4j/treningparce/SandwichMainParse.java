package ru.job4j.treningparce;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SandwichMainParse {
    public static void main(String... args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SandwichHandler sh = new SandwichHandler();

        File file = new File("C:\\projects\\sirotkinmaksim\\chapter_002\\src\\main\\resources\\sandwich.xml");

        Sandwich sandwich = sh.getSandwich();
        System.out.println();



        if (file.exists()) {
            parser.parse(file, sh);
        }
    }
}
