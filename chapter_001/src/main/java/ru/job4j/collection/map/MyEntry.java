package ru.job4j.collection.map;

public class MyEntry<L, O> {
    private L key;
    private O value;

    public MyEntry(L key, O value) {
        this.key = key;
        this.value = value;
    }

    public L getKey() {
        return key;
    }

    public O getValue() {
        return value;
    }
}
