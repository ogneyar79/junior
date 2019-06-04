package ru.job4j.magnit;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * The class converts a XML document to another XML document with different structure.
 *
 * @author Maksim Sirotkin(maksimus.s@mail.ru)
 * @version 0.1$
 * @since 0.1
 * 02.o6.2019
 */
public class ConvertXSQT {

    /**
     * Method converts a XML document to another XML with different structure.
     *
     * @param source to be converted.
     * @param dest   converted file.
     * @param scheme transformation patern.
     * @throws TransformerException if exception.
     */
    public void convert(File source, File dest, File scheme) throws TransformerException {
        System.out.println("The Converting of the XML to another started.");
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(scheme));
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new StreamSource(source), new StreamResult(dest));

        System.out.println("The conversion Has finished.");
    }

}
