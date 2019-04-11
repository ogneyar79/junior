package ru.job4j.collection.jeneric;

public interface Store<T> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
