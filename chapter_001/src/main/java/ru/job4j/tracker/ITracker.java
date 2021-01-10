package ru.job4j.tracker;

import java.util.List;

public interface ITracker {
    Item add(Item item);

    void replace(int id, Item item);

    void delete(int id);

    Item[] findAll();

    List<Item> findByName(String key);

    Item findById(String id);
}
