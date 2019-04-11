package ru.job4j.collection.map;

public class CatHashArray<K> {
    private int indexLengthc;
    Object[] objects = new Object[indexLengthc];

    private int hash(final K key) {
        int hash = 31;
        hash = hash * 31 + key.hashCode();

        return hash % this.objects.length;
    }

    public void add(K key) {

        objects[hash(key)] = key;
    }

}
