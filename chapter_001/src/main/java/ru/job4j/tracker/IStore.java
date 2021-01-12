package ru.job4j.tracker;

import java.util.List;

public interface IStore {
    ItemS add(ItemS item);
    boolean replace(String id, ItemS item);
    boolean delete(String id);
    List<ItemS> findAll();
    List<ItemS> findByName(String key);
    ItemS findById(String id);

}
