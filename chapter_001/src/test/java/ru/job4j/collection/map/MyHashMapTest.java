package ru.job4j.collection.map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MyHashMapTest {

    MyHashMap<Integer, String> myHashMap;

    @Before
    public void setUp() throws Exception {
        myHashMap = new MyHashMap<>();
        myHashMap.insert(0, "Мурзик");
        myHashMap.insert(1, "Рыжик");
        myHashMap.insert(2, "Барсик");
        myHashMap.insert(3, "Тайсон");

    }

    @Test
    public void insertAndGetValue() throws Exception {
        assertThat(myHashMap.getValue(2), is("Барсик"));
        assertThat(myHashMap.getValue(3), is("Тайсон"));
        assertThat(myHashMap.getValue(0), is("Мурзик"));
    }

    @Test
    public void delete() throws Exception {
        assertThat(myHashMap.delete(0), is(true));
    }

    @Test
    public void reStartHashFunction() throws Exception {

        for (int i = 0; i < 20; i++) {
            myHashMap.insert(i, "Odin");
        }
        int containerLength = myHashMap.containerMap.getContainer().length;
        assertThat(containerLength, is(40));

    }
}