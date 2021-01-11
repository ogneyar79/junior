package ru.job4j.tracker;

/**
 * класс Item for kreating orders.
 *
 * @author Sirotkin.
 */
public class Item {

    private String id;

    /**
     * @ param field name.
     */
    private String name;

    /**
     * @ param field description.
     */
    private String description;

    /**
     * @ param field create.
     */
    private long creator;

    /**
     * method for creaction Item object.
     */
    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    /**
     * method for creaction Item object.
     *
     * @param name        String
     * @param description String
     * @param creator     long
     */
    public Item(String name, String description, long creator) {
        this.name = name;
        this.description = description;
        this.creator = creator;
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
     * method for getting create.
     *
     * @return create
     */
    public long getCreator() {
        return this.creator;
    }

    /**
     * method for getting id.
     *
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * method for setting id.
     *
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * method for setting name.
     *
     * @param name String
     * @return this
     */
    public Item inputName(String name) {
        this.name = name;
        return this;
    }

    /**
     * method for setting dedcription.
     *
     * @param description String
     * @return this
     */
    public Item inputDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * method for setting create.
     *
     * @param create long
     * @return this
     */
    public Item inputCreate(long create) {
        this.creator = create;
        return this;
    }

    public void setName(String s) {
        this.name = name;
    }
}