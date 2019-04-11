package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorIteratorInteger implements Iterator<Iterator<Integer>> {
    Iterator<Integer> litleIterator;
    int indexIteratorObject = 0;

    List<Iterator<Integer>> arraysIteratorListInteger = new ArrayList<>();

    public IteratorIteratorInteger(List<Iterator<Integer>> arraysIteratorListInteger) {
        this.arraysIteratorListInteger = arraysIteratorListInteger;
    }


    @Override
    public boolean hasNext() {
        return indexIteratorObject < arraysIteratorListInteger.size();
    }

    @Override
    public Iterator<Integer> next() {

        return arraysIteratorListInteger.get(indexIteratorObject++);
    }
}
