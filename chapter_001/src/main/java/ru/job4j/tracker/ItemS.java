package ru.job4j.tracker;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items")
public class ItemS implements IItem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * @ param field name.
     */
    private String name;

    /**
     * @ param field description.
     */

    @Column(name = "description")
    private String description;

    public ItemS() {
    }

    public ItemS(String name) {
        this.name = name;
    }

    public ItemS(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * method for getting name.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * method for getting description.
     *
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * method for getting id.
     *
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * method for setting id.
     *
     * @param id String
     */
    public void setId(int id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemS itemS = (ItemS) o;
        return id == itemS.id && Objects.equals(name, itemS.name) && Objects.equals(description, itemS.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
