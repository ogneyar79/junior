package ru.job4j.magnit;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * SAX parser class.
 *
 * @author Maksim Sirotkin(maksimus.s@mail.ru)
 * @version 0.1$
 * @since 0.1
 * 02.06.2019
 */
public class SumSAXParser {

    private long sum = 0;

    public long parseSum (File file) throws ParserConfigurationException, SAXException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        FieldCounter counter = new FieldCounter();



        return sum;
    }


}
