package ru.job4j.iterator;

import java.util.Iterator;

public class IteratorArrayMIn implements Iterator<Integer> {
    private final int[] values;

    public int getIndex() {
        return index;
    }

    private int index = 0;

    public IteratorArrayMIn(final int[] values) {
        this.values = values;
    }


    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public Integer next() {
        return values[index++];
    }
}
