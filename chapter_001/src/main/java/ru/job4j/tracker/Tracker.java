package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * класс Tracker roll for array where we keep orders.
 *
 * @author Sirotkin.
 * @return s
 */
public class Tracker {

    /**
     * @ param value position, show quantity items and where items[position] we get new item.
     */
    private int position = 0;

    /**
     * @ param value Item [].
     */
    private List<Item> items = new ArrayList<Item>();

    /**
     * @ param RN Random.
     */
    private static final Random RN = new Random();

    /**
     * method for getting items.
     *
     * @return items[]
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * method for creating Id.
     *
     * @return valueOf
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * method for add Item item at Item[] and here set Id.
     *
     * @param item Item
     * @return item
     */
    public Item add(Item item) {

        item.setId(String.valueOf(this.generateId()));
        this.items.add(position, item);
        position++;
        return item;
    }

    /**
     * method for find item via id.
     *
     * @param id String
     * @return the item
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * method for get copy array from items without [i] = Null.
     *
     * @return result[]
     */
    public List<Item> getAll() {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {

            if (item != null) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * metod for changing our array [].
     *
     * @param item Item
     */
    public void update(Item item) {
        String id;
        id = item.getId();
        for (int index = 0; index != position; index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.set(index, item);
                break;
            }
        }
    }

    /**
     * method for deleted our items[i] = null and move to end list, and changed position.
     *
     * @param item Item
     */
    public void delete(Item item) {
        String id;
        id = item.getId();
        for (int index = 0; index != position; index++) {
            if (this.items.get(index).getId().equals(id)) {
                this.items.set(index, null);
                break;
            }

        }

        for (int i = 0; i != position; i++) {
            if (this.items.get(i) == null) {
                this.items.set(i, this.items.get(position - 1));
                this.items.set(position - 1, null);
                break;
            }

        }
        position--;
    }

    /**
     * metod for find our items[i], using name.
     *
     * @param key String
     * @return result Arraays.copyOf
     */
    List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }
}