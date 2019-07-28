package ru.job4j.magnit;

import org.junit.Test;

import javax.xml.transform.TransformerException;
import java.io.File;

import static org.junit.Assert.*;

public class ConvertXSQTTest {

    File sourceXml = new File("storeXml.xml");
    File destXml = new File("convertedFile.xml");
    File shemeOfTransformation = new File(getClass().getClassLoader().getResource("template.xsl").getFile());

    ConvertXSQT conversion = new ConvertXSQT();

    @Test
    public void checkConvertionOneXmlAnotherByShem() throws TransformerException {

        conversion.convert(sourceXml, destXml, shemeOfTransformation);
    }


}