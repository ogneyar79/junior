package ru.job4j.collection.jeneric;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    Object[] objects;
    int index;


    public void add(T model) {

        this.objects[index++] = model;

    }

    public T get(int position) {

        return (T) this.objects[position];
    }

    public void set(int position, T model) {
        this.objects[position] = model;
    }

    public void delete(int index) {
        this.objects[index--] = null;

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int indexI;

            @Override
            public boolean hasNext() {
                return indexI < objects.length;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[indexI++];
            }
        };
    }

    public int getIndex() {
        return index;
    }
}
