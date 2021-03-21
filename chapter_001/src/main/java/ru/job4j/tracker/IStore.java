package ru.job4j.tracker;

import java.util.List;

public interface IStore {
    ItemS add(ItemS item);
    boolean replace(ItemS item);
    boolean delete(int id);
    List<ItemS> findAll();
    List<ItemS> findByName(String key);
    ItemS findById(int id);

}
