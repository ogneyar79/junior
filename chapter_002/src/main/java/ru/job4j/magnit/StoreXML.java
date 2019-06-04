package ru.job4j.magnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;


/**
 * The class converts the List of SQLite database items to XML.
 *
 *  @author Sirotkin Maksimus(maksimus.s@mail.ru)
 *  @version 0.1$
 *  @since 0.1
 *  28.05.2019
 */
public class StoreXML {

    /**
     * File to save.
     */
    private File target;

    public StoreXML(File target) {
        this.target = target;
    }


    /**
     * The method turn the list of database elements into XML.
     * @param list of items to convert.
     */
    public void save(List<Entry> list) {
        System.out.println("Database transform to XML started.");
        Entries entries = new Entries();
        entries.entry = list;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class, Entry.class);
            Marshaller mar = jaxbContext.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(entries, this.target);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("transformation of DateBase to XML  has finished.");
    }

}
