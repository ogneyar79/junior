package ru.job4j.trackersql;

import java.util.List;

public interface ITracker {

    ItemS add(ItemS itemS);
    boolean replace(int id, ItemS itemS);
    boolean delete(int id);
    List<ItemS> getAll();
    List<ItemS> findByName(String key);
    ItemS findById(int id);
}
