package ru.job4j.collection.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class DinamicArraycontainerForHashMapTest {

    DinamicArraycontainerForHashMap<Integer> arraycontainer = new DinamicArraycontainerForHashMap<>();

    @Before
    public void setUp() throws Exception {
        arraycontainer.set(0, 0);
        arraycontainer.set(3, 3);
        arraycontainer.set(1, 1);
        arraycontainer.set(6, 6);
    }

    @Test

    public void checkIterator() throws Exception {
        System.out.println(arraycontainer.getSize());

        Iterator<Integer> iteratorArrayContainer = arraycontainer.iterator();
        System.out.println(iteratorArrayContainer.next());
        iteratorArrayContainer.next();
        System.out.println(iteratorArrayContainer.next());
        System.out.println(iteratorArrayContainer.next());
       
    }
}