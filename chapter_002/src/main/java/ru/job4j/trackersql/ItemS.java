package ru.job4j.trackersql;

import java.util.Objects;

/**
 * класс ItemS for kreating orders.
 *
 * @author Sirotkin.
 */
public class ItemS {

    private int id;

    private String name;

    private String description;

    public ItemS(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ItemS(String name, String description, int id) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemS itemS = (ItemS) o;
        return id == itemS.id && Objects.equals(name, itemS.name) && Objects.equals(description, itemS.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
