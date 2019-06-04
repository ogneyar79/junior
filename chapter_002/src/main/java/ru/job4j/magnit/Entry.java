package ru.job4j.magnit;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The database objects class for converting to XML.
 *  @author Maksim Sirotkin(maksimus.s@mail.ru)
 *  @version 0.1$
 *  @since 0.1
 *  18.12.2019
 */
@XmlRootElement
public class Entry {


    private int field;

    public int getField() {
        return field;
    }

    @XmlElement
    public void setField(int field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object obj) {
        boolean valid = false;
        if (obj != null) {
            if (this == obj) {
                valid = true;
            }
            if (!valid && getClass() == obj.getClass()) {
                Entry entry = (Entry) obj;
                valid = this.field == entry.field;
            }
        }
        return valid;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
