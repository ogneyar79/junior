package ru.job4j.magnit;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * A wrapper class of list of database objects for converting a database to XML.
 *
 * @author Maksimus Sirotkin(maksimus.s@mail.ru)
 * @version 0.1$
 * @since 0.1
 * 28.05.2019
 */
@XmlRootElement(name = "entries")
public class Entries {

    @XmlElement(name = "entry")
    public List<Entry> entry;


}
